package co.com.sofkau.appagilismo.historiadeusuario.rutas;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.ActualizarHistoriaDeUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ActualizarHistoriaDeUsuarioRuta {

    @Bean
    public RouterFunction<ServerResponse> actualizarHistoriaDeUsuario(ActualizarHistoriaDeUsuarioCasoDeUso actualizarHistoriaDeUsuarioCasoDeUso){
        Function<HistoriaDeUsuarioDTO, Mono<ServerResponse>> actualizarHistoriaDeUsuario = historiaDeUsuarioDTO -> actualizarHistoriaDeUsuarioCasoDeUso.crearHistoriaDeUsuario(historiaDeUsuarioDTO)
                .flatMap(resultado -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(resultado)
                );
        return route(PUT("/historia/actualizar").and(accept(MediaType.APPLICATION_JSON)),
        request -> request.bodyToMono(HistoriaDeUsuarioDTO.class)
                .flatMap(actualizarHistoriaDeUsuario)
        );
    }

}
