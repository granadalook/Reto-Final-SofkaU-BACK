package co.com.sofkau.appagilismo.historiadeusuario.mapper;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class MapperHistoriaDeUsuario {


    private final TareaRepositorio tareaRepositorio;

    private final MapperTarea mapperTarea;

    public MapperHistoriaDeUsuario(TareaRepositorio tareaRepositorio, MapperTarea mapperTarea){
        this.tareaRepositorio=tareaRepositorio;
        this.mapperTarea=mapperTarea;
    }

    public Function<HistoriaDeUsuarioDTO, HistoriaDeUsuario> mapperAHistoriaDeUsuario(String id){
        return updateHistoriaDeUsuario -> {
            var historiaDeUsuario = new HistoriaDeUsuario();
            historiaDeUsuario.setHistoriaUsuarioId(id);
            historiaDeUsuario.setTituloHistoriaUsuario(updateHistoriaDeUsuario.getTituloHistoriaUsuario());
            historiaDeUsuario.setDescripcion(updateHistoriaDeUsuario.getDescripcion());
            historiaDeUsuario.setEstimacion(updateHistoriaDeUsuario.getEstimacion());
            historiaDeUsuario.setEstado(updateHistoriaDeUsuario.getEstado());
            historiaDeUsuario.setPorcentajeDeAvance(calcularPorcentajeDeAvance(updateHistoriaDeUsuario));
            historiaDeUsuario.setLiderTecnicoId(updateHistoriaDeUsuario.getLiderTecnicoId());
            historiaDeUsuario.setDesarrolladorId(updateHistoriaDeUsuario.getDesarrolladorId());
            historiaDeUsuario.setProyectoId(updateHistoriaDeUsuario.getProyectoId());
            return historiaDeUsuario;
        };
    }

    private Integer calcularPorcentajeDeAvance(HistoriaDeUsuarioDTO historiaDeUsuarioDTO){
       Double completas = Double.valueOf(historiaDeUsuarioDTO.getTareas().stream().filter(tarea -> {
            return tarea.isCompleta()==true;
        }).count());

        Double total = Double.valueOf(historiaDeUsuarioDTO.getTareas().size());

        return Math.toIntExact((long) ((completas/total)*100));
    }

    public Function<HistoriaDeUsuario, HistoriaDeUsuarioDTO> mapperAHistoriaDeUsuarioDTO(){
        return entity -> new HistoriaDeUsuarioDTO(
                entity.getHistoriaUsuarioId(),
                entity.getTituloHistoriaUsuario(),
                entity.getDescripcion(),
                entity.getEstimacion(),
                entity.getEstado(),
                entity.isCompleta(),
                entity.getPorcentajeDeAvance(),
                entity.getLiderTecnicoId(),
                entity.getDesarrolladorId(),
                entity.getProyectoId()
        );
    }

    public Function<HistoriaDeUsuarioDTO, Mono<HistoriaDeUsuarioDTO>> mapperHistoriaDeUsuarioActualizada(){
        return historiaDeUsuarioDTO ->
                Mono.just(historiaDeUsuarioDTO).zipWith(
                        tareaRepositorio.findAllByHistoriaUsuarioId(historiaDeUsuarioDTO.getHistoriaUsuarioId())
                                .map(mapperTarea.mapperATareaDTO())
                                .collectList(),
                        (historiaDeUsuario, tareas) -> {
                            historiaDeUsuario.setTareas(tareas);
                            return historiaDeUsuario;
                        }
                );
    }


}
