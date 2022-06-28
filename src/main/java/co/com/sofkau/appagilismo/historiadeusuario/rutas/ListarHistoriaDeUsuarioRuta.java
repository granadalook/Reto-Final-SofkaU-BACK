package co.com.sofkau.appagilismo.historiadeusuario.rutas;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.ListarHistoriasDeUsuarioCasoDeUso;
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
public class ListarHistoriaDeUsuarioRuta {

    @Bean
    public RouterFunction<ServerResponse> obtenerTodasLasHistoriasDeUsuario(ListarHistoriasDeUsuarioCasoDeUso listarHistoriasDeUsuarioCasoDeUso){
        return route(GET("historia/obtenerTodas").and(accept(APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(listarHistoriasDeUsuarioCasoDeUso.get(), HistoriaDeUsuarioDTO.class))
        );
    }
}
