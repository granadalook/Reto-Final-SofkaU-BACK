package co.com.sofkau.appagilismo.historiadeusuario.rutas;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.ListarHistoriasPorUsuarioIdCasoDeUso;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ListarHistoriasPorUsuarioIdRuta {

    @Bean
    public RouterFunction<ServerResponse> listarHistoriasPorUsuarioId(ListarHistoriasPorUsuarioIdCasoDeUso listarHistoriasPorUsuarioIdCasoDeUso){
        return route(GET("/historia/obtenerPorUsuarioId/{usuarioId}").and(accept(APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(listarHistoriasPorUsuarioIdCasoDeUso.apply(request.pathVariable("usuarioId")),
                                        HistoriaDeUsuarioDTO.class
                                        ))
                );
    }
}
