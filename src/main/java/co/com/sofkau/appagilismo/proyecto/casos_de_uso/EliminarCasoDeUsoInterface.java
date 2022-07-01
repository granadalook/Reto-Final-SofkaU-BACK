package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import reactor.core.publisher.Mono;

/**
 * Interfaz funcional de eliminar un proyecto.
 */
@FunctionalInterface
public interface EliminarCasoDeUsoInterface {

    /**
     * Metodo que permite eliminar un proyecto.
     * @param idProyecto
     * @return
     */
    Mono<Void> deleteProyectoById(String idProyecto);
}
