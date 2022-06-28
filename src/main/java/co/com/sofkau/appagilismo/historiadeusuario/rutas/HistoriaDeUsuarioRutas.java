package co.com.sofkau.appagilismo.historiadeusuario.rutas;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.CrearHistoriaDeUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.ListarHistoriasDeUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class HistoriaDeUsuarioRutas {

    @Bean
    public RouterFunction<ServerResponse> create(CrearHistoriaDeUsuarioCasoDeUso crearHistoriaDeUsuarioCasoDeUso){
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

    @Bean
    public RouterFunction<ServerResponse> obtenerTodasLasHistoriasDeUsuario(ListarHistoriasDeUsuarioCasoDeUso listarHistoriasDeUsuarioCasoDeUso){
        return route(GET("historia/obtenerTodas").and(accept(APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(listarHistoriasDeUsuarioCasoDeUso.get(), HistoriaDeUsuarioDTO.class))
                );
    }
}
