package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Clase que representa el caso de uso de traer una lista de historias de usuarios.
 */
@Service
@Validated
public class ListarHistoriasDeUsuarioCasoDeUso implements Supplier<Flux<HistoriaDeUsuarioDTO>> {

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    private final TareaRepositorio tareaRepositorio;

    private final MapperTarea mapperTarea;

    public ListarHistoriasDeUsuarioCasoDeUso(MapperHistoriaDeUsuario mapperHistoriaDeUsuario, HistoriaDeUsuarioRepositorio repositorio, TareaRepositorio tareaRepositorio, MapperTarea mapperTarea) {
        this.repositorio = repositorio;
        this.mapperHistoriaDeUsuario=mapperHistoriaDeUsuario;
        this.tareaRepositorio=tareaRepositorio;
        this.mapperTarea=mapperTarea;
    }

    /**
     * Metodo que permite traer una lista de las hisotrias de usuario con sus respectivas lista de tareas.
     * @return
     */
    @Override
    public Flux<HistoriaDeUsuarioDTO> get() {
        return repositorio.findAll()
                .map(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuarioDTO())
                .flatMap(mapperHistoriaDeUsuarioAgregado());
    }

    /**
     * Metodo que permite traer la lista de las tareas vinculadas a una historia de usuario.
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
