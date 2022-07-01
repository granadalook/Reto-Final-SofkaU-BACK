package co.com.sofkau.appagilismo.proyecto.rutas;

import co.com.sofkau.appagilismo.proyecto.casos_de_uso.ActualizarProyectoCasoDeUso;
import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ActualizarProyectoRuta {

    @Bean
    public RouterFunction<ServerResponse> actualizarProyecto(ActualizarProyectoCasoDeUso actualizarProyectoCasoDeUso){
        Function<ProyectoDTO, Mono<ServerResponse>> actualizarProyecto = ProyectoDTO -> actualizarProyectoCasoDeUso.guardarProyecto(ProyectoDTO)
                .flatMap(resultado -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(resultado));
        return route(
                PUT("proyecto/actualizar").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProyectoDTO.class)
                        .flatMap(actualizarProyecto));
    }
}