package co.com.sofkau.appagilismo.tarea.casos_de_uso;


import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
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
    public Mono<Void> eliminarTarea(String historiausuarioId) {
        Objects.requireNonNull(historiausuarioId, "El id de la historia del Usuario debe existir");
        return tareaRepositorio.deleteByHistoriaUsuarioId(historiausuarioId)
                .switchIfEmpty(Mono.defer(() -> tareaRepositorio.deleteByHistoriaUsuarioId(historiausuarioId)));
    }
}
