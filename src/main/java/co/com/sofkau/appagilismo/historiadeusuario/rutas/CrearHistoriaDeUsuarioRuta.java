package co.com.sofkau.appagilismo.historiadeusuario.rutas;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.CrearHistoriaDeUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrearHistoriaDeUsuarioRuta {

    @Bean
    public RouterFunction<ServerResponse> crearHistoriaDeUsuario(CrearHistoriaDeUsuarioCasoDeUso crearHistoriaDeUsuarioCasoDeUso){
        Function<HistoriaDeUsuarioDTO, Mono<ServerResponse>> crearHistoriaDeUsuario = historiaDeUsuarioDTO -> crearHistoriaDeUsuarioCasoDeUso.crearHistoriaDeUsuario(historiaDeUsuarioDTO)
                .flatMap(resultado -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(resultado)
                );
        return route(POST("/historia/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(HistoriaDeUsuarioDTO.class)
                        .flatMap(crearHistoriaDeUsuario)
                );
    }
}
