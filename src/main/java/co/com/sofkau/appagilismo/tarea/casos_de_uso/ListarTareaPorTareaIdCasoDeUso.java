package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import co.com.sofkau.appagilismo.excepciones.ExcepcionPersonalizadaInternalServerError;
import co.com.sofkau.appagilismo.excepciones.ExcepcionPersonalizadaNotFound;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class ListarTareaPorTareaIdCasoDeUso implements Function<String, Mono<TareaDTO>> {

    private final MapperTarea mapperTarea;

    private final TareaRepositorio tareaRepositorio;


    public ListarTareaPorTareaIdCasoDeUso(MapperTarea mapperTarea, TareaRepositorio tareaRepositorio){
        this.mapperTarea=mapperTarea;
        this.tareaRepositorio=tareaRepositorio;
    }

    @Override
    public Mono<TareaDTO> apply(String tareaId) {
        return tareaRepositorio.findById(tareaId)
                .map(mapperTarea.mapperATareaDTO())
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .onErrorResume(error -> {
                    if (error.getMessage().equals("404 NOT_FOUND")) {
                        return Mono.error(new ExcepcionPersonalizadaNotFound("Tarea no se encuentra registrada"));
                    }
                    return Mono.error(new ExcepcionPersonalizadaInternalServerError("Campos vacios"));
                });
    }
}
