package co.com.sofkau.appagilismo.tarea.casos_de_uso;


import co.com.sofkau.appagilismo.excepciones.ExcepcionPersonalizadaInternalServerError;
import co.com.sofkau.appagilismo.excepciones.ExcepcionPersonalizadaNotFound;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class EliminarTareaCasoDeUso implements EliminarTareaInterface {

    private final TareaRepositorio tareaRepositorio;
    private final HistoriaDeUsuarioRepositorio historiaDeUsuarioRepositorio;
    private MapperTarea mapperTarea;

    public EliminarTareaCasoDeUso(TareaRepositorio tareaRepositorio, HistoriaDeUsuarioRepositorio historiaDeUsuarioRepositorio, MapperTarea mapperTarea) {
        this.tareaRepositorio = tareaRepositorio;
        this.historiaDeUsuarioRepositorio = historiaDeUsuarioRepositorio;
        this.mapperTarea = mapperTarea;
    }

    @Override
    public Mono<Void> eliminarTarea(String tareaId) {
        Objects.requireNonNull(tareaId, "El id de la tarea debe existir");
        return tareaRepositorio.deleteByTareaId(tareaId);
                //.switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
                /*.onErrorResume(error -> {
                    if (error.getMessage().equals("404 NOT_FOUND")) {
                        return Mono.error(new ExcepcionPersonalizadaNotFound("Tarea no se encuentra registrada"));
                    }
                    return Mono.error(new ExcepcionPersonalizadaInternalServerError("Campos vacios."));
                });*/

    }
}
