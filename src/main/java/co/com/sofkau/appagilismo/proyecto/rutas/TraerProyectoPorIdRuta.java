package co.com.sofkau.appagilismo.proyecto.rutas;

import co.com.sofkau.appagilismo.proyecto.casos_de_uso.TraerProyectoPorIdcasoDeUso;
import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TraerProyectoPorIdRuta {

    @Bean
    public RouterFunction<ServerResponse> traerProyectoPorId(TraerProyectoPorIdcasoDeUso traerProyectoPorIdcasoDeUso){
        return route(
                GET("/proyecto/{proyectoId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                traerProyectoPorIdcasoDeUso.apply(request.pathVariable("proyectoId")),
                                ProyectoDTO.class)));
    }
}
