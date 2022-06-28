package co.com.sofkau.appagilismo.proyecto.rutas;

import co.com.sofkau.appagilismo.proyecto.casos_de_uso.EliminarProyectoCasoDeUso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EliminarProyectoRuta {

    @Bean
    public RouterFunction<ServerResponse> eliminarProyecto(EliminarProyectoCasoDeUso eliminarProyectoCasoDeUso) {
        return route(
                DELETE("/eliminarProyecto/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                eliminarProyectoCasoDeUso.eliminarProyecto(request.pathVariable("id")),
                                Void.class)));
    }
}
