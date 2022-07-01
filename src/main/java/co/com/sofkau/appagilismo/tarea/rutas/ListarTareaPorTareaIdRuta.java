package co.com.sofkau.appagilismo.tarea.rutas;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.tarea.casos_de_uso.ListarTareaPorTareaIdCasoDeUso;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
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
public class ListarTareaPorTareaIdRuta {

    @Bean
    public RouterFunction<ServerResponse> listarTareaPorTareaId(ListarTareaPorTareaIdCasoDeUso listarTareaPorTareaIdCasoDeUso){
        return route(GET("/tarea/listarPorId/{tareaId}").and(accept(APPLICATION_JSON)),
        request -> ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(listarTareaPorTareaIdCasoDeUso.apply(request.pathVariable("tareaId")),
                        TareaDTO.class
                ))
                );
    }

}
