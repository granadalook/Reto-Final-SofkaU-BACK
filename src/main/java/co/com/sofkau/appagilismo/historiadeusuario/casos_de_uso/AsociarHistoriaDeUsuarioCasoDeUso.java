package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.excepciones.ExcepcionPersonalizadaInternalServerError;
import co.com.sofkau.appagilismo.excepciones.ExcepcionPersonalizadaNotFound;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

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

    @Override
    public Mono<HistoriaDeUsuarioDTO> apply(String id) {
        //Objects.requireNonNull(id, "Id es obligatorio.");
        return repositorio.findById(id)
                .map(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuarioDTO())
                .flatMap(mapperHistoriaDeUsuarioAgregado())
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .onErrorResume(error -> {
                    if (error.getMessage().equals("404 NOT_FOUND")) {
                        return Mono.error(new ExcepcionPersonalizadaNotFound("Tarea no se encuentra registrada"));
                    }
                    return Mono.error(new ExcepcionPersonalizadaInternalServerError("Campos vacios"));
                });
    }

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
