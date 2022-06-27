package co.com.sofkau.appagilismo.proyecto.rutas;

import co.com.sofkau.appagilismo.proyecto.casos_de_uso.CrearProyectoCasoDeUso;
import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProyectoRutas {

    @Bean
    public RouterFunction<ServerResponse> crearProyecto(CrearProyectoCasoDeUso crearProyectoCasoDeUso){
        Function<ProyectoDTO, Mono<ServerResponse>> crearProyecto = proyectoDTO -> crearProyectoCasoDeUso.crearProyecto(proyectoDTO)
                .flatMap(resultado -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(resultado)
                );
        return route(POST("/proyecto/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProyectoDTO.class)
                        .flatMap(crearProyecto)
                );
    }
}
