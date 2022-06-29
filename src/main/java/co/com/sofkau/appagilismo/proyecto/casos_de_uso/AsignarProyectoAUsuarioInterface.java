package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AsignarProyectoAUsuarioInterface {

    Mono<Void> asignarProyecto(String usuarioId, String proyectoId);
}
