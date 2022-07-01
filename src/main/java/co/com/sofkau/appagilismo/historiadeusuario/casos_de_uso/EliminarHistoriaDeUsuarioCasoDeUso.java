package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

/**
 * Clase que representa el caso de uso de eliminar una historia de usuario por su Id.
 */
@Service
@Validated
public class EliminarHistoriaDeUsuarioCasoDeUso implements Function<String, Mono<Void>> {

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final TareaRepositorio tareaRepositorio;

    public EliminarHistoriaDeUsuarioCasoDeUso(HistoriaDeUsuarioRepositorio repositorio, TareaRepositorio tareaRepositorio){
        this.repositorio = repositorio;
        this.tareaRepositorio=tareaRepositorio;
    }

    /**
     * Metodo que permite eliminar una hisotria de usuario por su Id.
     * @param historiaUsuarioId the function argument
     * @return
     */
    @Override
    public Mono<Void> apply(String historiaUsuarioId) {
        Objects.requireNonNull(historiaUsuarioId, "Id es campo obligatorio.");
        return repositorio.deleteById(historiaUsuarioId)
                .switchIfEmpty(Mono.defer(() -> tareaRepositorio.deleteByHistoriaUsuarioId(historiaUsuarioId)));
    }
}
