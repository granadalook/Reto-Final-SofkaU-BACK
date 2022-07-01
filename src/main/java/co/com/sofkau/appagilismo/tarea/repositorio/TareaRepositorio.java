package co.com.sofkau.appagilismo.tarea.repositorio;

import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Representa a una interfaz que hereda de la interfaz ReactiveMongoRepository que tiene SpringBoot, todos sus metodos.
 */
@Repository
public interface TareaRepositorio extends ReactiveMongoRepository<Tarea, String> {

    /**
     * Metodo que permite eleminar una historia de usuario por su Id.
     * @param historiaUsuarioId
     * @return Mono<Void>
     */
    Mono<Void> deleteByHistoriaUsuarioId(String historiaUsuarioId);

    /**
     * Metodo que permite traer todas las tareas vinculadas a una histroia de usuario.
     * @param historiaUsuarioId
     * @return Lista de objetos de Tarea.
     */
    Flux<Tarea> findAllByHistoriaUsuarioId(String historiaUsuarioId);
}
