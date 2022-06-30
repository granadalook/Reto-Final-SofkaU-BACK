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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class ListarHistoriasPorDesarrolladorIdCasoDeUso implements Function<String, Flux<HistoriaDeUsuarioDTO>> {

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;



    public ListarHistoriasPorDesarrolladorIdCasoDeUso(HistoriaDeUsuarioRepositorio repositorio, MapperHistoriaDeUsuario mapperHistoriaDeUsuario,TareaRepositorio tareaRepositorio, MapperTarea mapperTarea){
        this.repositorio=repositorio;
        this.mapperHistoriaDeUsuario=mapperHistoriaDeUsuario;
    }

    @Override
    public Flux<HistoriaDeUsuarioDTO> apply(String desarrolladorId) {
        return repositorio.findAllByDesarrolladorId(desarrolladorId)
                .map(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuarioDTO())
                .flatMap(mapperHistoriaDeUsuario.mapperHistoriaDeUsuarioActualizada())
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .onErrorResume(error -> {
                    if (error.getMessage().equals("404 NOT_FOUND")) {
                        return Mono.error(new ExcepcionPersonalizadaNotFound("Usuario no se encuentra registrado"));
                    }
                    return Mono.error(new ExcepcionPersonalizadaInternalServerError("Campos vacios"));
                });

    }
}
