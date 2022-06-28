package co.com.sofkau.appagilismo.usuario.rutas;

import co.com.sofkau.appagilismo.usuario.casos_de_uso.ListarUsuariosPorRolCasoDeUso;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ListarUsuariosPorRolRuta {

    @Bean
    public RouterFunction<ServerResponse> listarUsuariosPorRol(ListarUsuariosPorRolCasoDeUso listarUsuariosPorRolCasoDeUso){
        return route(GET("/usuario/listarPorRol/{rol}").and(accept(APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                listarUsuariosPorRolCasoDeUso.apply(request.pathVariable("rol")),
                                UsuarioDTO.class
                        ))
                );
    }
}
