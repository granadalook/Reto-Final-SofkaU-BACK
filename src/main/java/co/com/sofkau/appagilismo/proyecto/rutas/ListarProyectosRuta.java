package co.com.sofkau.appagilismo.proyecto.rutas;

import co.com.sofkau.appagilismo.proyecto.casos_de_uso.ListarProyectosCasoDeUso;
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
public class ListarProyectosRuta {

    @Bean
    public RouterFunction<ServerResponse> listarProyectos(ListarProyectosCasoDeUso listarProyectosCasoDeUso){
    return route(GET("/listarProyectos"),
            request -> ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromPublisher(listarProyectosCasoDeUso.get(),
                            ProyectoDTO.class)));
    }
}