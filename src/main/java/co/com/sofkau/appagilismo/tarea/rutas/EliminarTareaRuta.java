package co.com.sofkau.appagilismo.tarea.rutas;

import co.com.sofkau.appagilismo.tarea.casos_de_uso.EliminarTareaCasoDeUso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Clase que permite configurar la ruta de salida para eliminar una tarea por su Id.
 */
@Configuration
public class EliminarTareaRuta {

    /**
     * Metodo que define el entrypoint del POST para eliminar una tarea por su Id.
     * @param eliminarTareaCasoDeUso
     * @return Respuesta de la API con un Body vacio y un codigo de status.
     */
    @Bean
    public RouterFunction<ServerResponse> eliminarTarea(EliminarTareaCasoDeUso eliminarTareaCasoDeUso) {
        return route(
                DELETE("/eliminarTarea/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                eliminarTareaCasoDeUso.eliminarTarea(request.pathVariable("id")),
                                Void.class))
        );
    }
}
