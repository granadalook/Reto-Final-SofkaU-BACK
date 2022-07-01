package co.com.sofkau.appagilismo.tarea.rutas;

import co.com.sofkau.appagilismo.tarea.casos_de_uso.CrearTareaCasoDeUso;
import co.com.sofkau.appagilismo.tarea.casos_de_uso.EliminarTareaCasoDeUso;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EliminarTareaRuta {

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
