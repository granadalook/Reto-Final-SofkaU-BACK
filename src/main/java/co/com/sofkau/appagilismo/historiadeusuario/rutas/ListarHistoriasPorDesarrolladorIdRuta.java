package co.com.sofkau.appagilismo.historiadeusuario.rutas;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.ListarHistoriasPorDesarrolladorIdCasoDeUso;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
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
public class ListarHistoriasPorDesarrolladorIdRuta {

    @Bean
    public RouterFunction<ServerResponse> listarHistoriasPorDesarrolladorId(ListarHistoriasPorDesarrolladorIdCasoDeUso listarHistoriasPorDesarrolladorIdCasoDeUso){
        return route(GET("/historia/obtenerPorDesarrolladorId/{desarrolladorId}").and(accept(APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(listarHistoriasPorDesarrolladorIdCasoDeUso.apply(request.pathVariable("desarrolladorId")),
                                HistoriaDeUsuarioDTO.class
                        ))
        );
    }
}
