package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Clase que representa el caso de uso de asociar tareas a una historia de usuario.
 */
@Service
@Validated
public class AsociarHistoriaDeUsuarioCasoDeUso implements Function<String, Mono<HistoriaDeUsuarioDTO>> {

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final TareaRepositorio tareaRepositorio;

    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    private final MapperTarea mapperTarea;

    public AsociarHistoriaDeUsuarioCasoDeUso(MapperHistoriaDeUsuario mapperHistoriaDeUsuario,HistoriaDeUsuarioRepositorio repositorio,TareaRepositorio tareaRepositorio, MapperTarea mapperTarea){
        this.mapperHistoriaDeUsuario=mapperHistoriaDeUsuario;
        this.repositorio=repositorio;
        this.tareaRepositorio=tareaRepositorio;
        this.mapperTarea=mapperTarea;
    }

    /**
     * Metodo que permite asociar tareas a una nueva hisotria de usuario
     * @param id the function argument
     * @return
     */
    @Override
    public Mono<HistoriaDeUsuarioDTO> apply(String id) {
        return repositorio.findById(id)
                .map(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuarioDTO())
                .flatMap(mapperHistoriaDeUsuarioAgregado());
    }

    /**
     * Metodo que permite traer cada una de las tareas que estan vinculadas a una historia de usuario por su Id.
     * @return
     */
    private Function<HistoriaDeUsuarioDTO, Mono<HistoriaDeUsuarioDTO>> mapperHistoriaDeUsuarioAgregado(){
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
