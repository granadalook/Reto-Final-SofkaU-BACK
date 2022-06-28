package co.com.sofkau.appagilismo.historiadeusuario.rutas;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.EliminarHistoriaDeUsuarioCasoDeUso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class EliminarHistoriaDeUsuarioRuta {

    @Bean
    public RouterFunction<ServerResponse> eliminarHistoriaDeUsuario(EliminarHistoriaDeUsuarioCasoDeUso eliminarHistoriaDeUsuarioCasoDeUso){
        return route(DELETE("/historia/eliminar/{id}").and(accept(APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(eliminarHistoriaDeUsuarioCasoDeUso.apply(request.pathVariable("id")), Void.class))
        );
    }

}
