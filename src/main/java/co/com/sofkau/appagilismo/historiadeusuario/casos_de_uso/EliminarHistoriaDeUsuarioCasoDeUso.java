package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
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
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id, "Id es campo obligatorio.");
        return repositorio.deleteById(id)
                .switchIfEmpty(Mono.defer(() -> tareaRepositorio.eliminarPorHistoriaUsuarioId(id)));
    }
}
