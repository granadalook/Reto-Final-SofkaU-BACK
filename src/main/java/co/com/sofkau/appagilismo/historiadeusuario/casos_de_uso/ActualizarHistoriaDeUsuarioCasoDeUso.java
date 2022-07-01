package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class ActualizarHistoriaDeUsuarioCasoDeUso implements CrearHistoriaDeUsuarioInterface {

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    private final TareaRepositorio tareaRepositorio;

    private final MapperTarea mapperTarea;

    public ActualizarHistoriaDeUsuarioCasoDeUso(MapperHistoriaDeUsuario mapperHistoriaDeUsuario, HistoriaDeUsuarioRepositorio repositorio, TareaRepositorio tareaRepositorio, MapperTarea mapperTarea) {
        this.repositorio = repositorio;
        this.mapperHistoriaDeUsuario=mapperHistoriaDeUsuario;
        this.tareaRepositorio=tareaRepositorio;
        this.mapperTarea=mapperTarea;
    }

    @Override
    public Mono<HistoriaDeUsuarioDTO> crearHistoriaDeUsuario(HistoriaDeUsuarioDTO historiaDeUsuarioDTO) {
        //Objects.requireNonNull(historiaDeUsuarioDTO.getHistoriaUsuarioId(), "Id de la Historia De Usuario es requerido.");
        return repositorio.save(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuario(historiaDeUsuarioDTO.getHistoriaUsuarioId()).apply(historiaDeUsuarioDTO))
                .map(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuarioDTO())
                .flatMap(mapperHistoriaDeUsuarioActualizado());
    }

    private Function<HistoriaDeUsuarioDTO, Mono<HistoriaDeUsuarioDTO>> mapperHistoriaDeUsuarioActualizado(){
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
