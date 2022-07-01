package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface EliminarCasoDeUsoInterface {

    Mono<Void> deleteProyectoById(String idProyecto);
}
