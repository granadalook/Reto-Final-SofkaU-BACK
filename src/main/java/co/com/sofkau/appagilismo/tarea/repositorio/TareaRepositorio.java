package co.com.sofkau.appagilismo.tarea.repositorio;

import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TareaRepositorio extends ReactiveMongoRepository<Tarea, String> {

    Mono<Void> eliminarPorHistoriaUsuarioId(String historiaUsuarioId);

    Flux<Tarea> encontrarTodasPorHistoriaDeUsuarioId(String id);

}
