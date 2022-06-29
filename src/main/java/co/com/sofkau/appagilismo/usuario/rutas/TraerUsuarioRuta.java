package co.com.sofkau.appagilismo.usuario.rutas;

import co.com.sofkau.appagilismo.usuario.casos_de_uso.TraerUsuarioPorIdCasoDeUso;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TraerUsuarioRuta {

    @Bean
    public RouterFunction<ServerResponse> traerUsuarioPorId(TraerUsuarioPorIdCasoDeUso traerUsuarioPorIdCasoDeUso) {
        return route(
                GET("/usuario/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(traerUsuarioPorIdCasoDeUso.traerUsuarioPorId(request.pathVariable("id")),
                                UsuarioDTO.class)));
    }
}
