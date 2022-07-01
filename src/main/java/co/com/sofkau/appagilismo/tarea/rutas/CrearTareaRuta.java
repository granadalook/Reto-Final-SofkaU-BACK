package co.com.sofkau.appagilismo.tarea.rutas;

import co.com.sofkau.appagilismo.tarea.casos_de_uso.CrearTareaCasoDeUso;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
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

/**
 * Clase que permite configurar la ruta de salida para crear una tarea.
 */
@Configuration
public class CrearTareaRuta {

    /**
     * Metodo que define el entrypoint del POST para crear una nueva tarea de la API.
     * @param crearTareaCasoDeUso
     * @return Respuesta de la API con un Body de tipo TareaDTO y un codigo de status.
     */
    @Bean
    public RouterFunction<ServerResponse> crearTarea(CrearTareaCasoDeUso crearTareaCasoDeUso){
        Function<TareaDTO, Mono<ServerResponse>> crearTarea = TareaDTO -> crearTareaCasoDeUso.crearTarea(TareaDTO)
                .flatMap(respuesta -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(respuesta)
                );

        return route(POST("/tarea/crear").and(accept(MediaType.APPLICATION_JSON)),
            request -> request.bodyToMono(TareaDTO.class)
                    .flatMap(crearTarea));
    }
}
