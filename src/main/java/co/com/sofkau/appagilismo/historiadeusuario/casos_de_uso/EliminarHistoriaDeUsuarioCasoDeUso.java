package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.excepciones.ExcepcionPersonalizadaInternalServerError;
import co.com.sofkau.appagilismo.excepciones.ExcepcionPersonalizadaNotFound;
import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
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
public class EliminarHistoriaDeUsuarioCasoDeUso implements Function<String, Mono<Void>> {

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final TareaRepositorio tareaRepositorio;

    public EliminarHistoriaDeUsuarioCasoDeUso(HistoriaDeUsuarioRepositorio repositorio, TareaRepositorio tareaRepositorio){
        this.repositorio = repositorio;
        this.tareaRepositorio=tareaRepositorio;
    }

    @Override
    public Mono<Void> apply(String historiaUsuarioId) {
        //Mono<HistoriaDeUsuario> validacion = (repositorio.findById(historiaUsuarioId));
        return repositorio.deleteById(historiaUsuarioId)
                .switchIfEmpty(Mono.defer(() -> tareaRepositorio.deleteByTareaId(historiaUsuarioId)))
                .onErrorResume(error -> {
                    if (error.getMessage().equals("404 NOT_FOUND")) {
                        return Mono.error(new ExcepcionPersonalizadaNotFound("Historia de usuario no se encuentra registrada"));
                    }
                   /* if(validacion == null){
                        return Mono.error(new ExcepcionPersonalizadaInternalServerError("Campos vacios"));
                    }*/
                    return Mono.error(new ExcepcionPersonalizadaInternalServerError("Campos vacios"));
                });
    }
}
