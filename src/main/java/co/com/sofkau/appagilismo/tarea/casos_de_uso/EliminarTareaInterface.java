package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * Interfaz funcional de elimniar una tarea de acuerdo a un id de una historia de usuario.
 */
@FunctionalInterface
public interface EliminarTareaInterface  {

    /**
     * Metodo que permite eliminar una tarea.
     * @param historiausuarioId
     * @return Mono<Void>
     */
    Mono<Void> eliminarTarea (@Valid String historiausuarioId);
}
