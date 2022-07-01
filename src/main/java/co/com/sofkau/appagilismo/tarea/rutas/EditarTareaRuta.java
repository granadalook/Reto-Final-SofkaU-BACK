package co.com.sofkau.appagilismo.tarea.rutas;

import co.com.sofkau.appagilismo.tarea.casos_de_uso.EditarTareaCasoDeUso;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
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

/**
 * Clase que permite configurar la ruta de salida para editar una tarea.
 */
@Configuration
public class EditarTareaRuta {

    /**
     * Metodo que define el entrypoint del POST para editar una tarea de la API.
     * @param editarTareaCasoDeUso
     * @return Respuesta de la API con un Body de tipo TareaDTO y un codigo de status.
     */
    @Bean
    public RouterFunction<ServerResponse> editarTarea(EditarTareaCasoDeUso editarTareaCasoDeUso){
        Function<TareaDTO, Mono<ServerResponse>> editarTarea = TareaDTO -> editarTareaCasoDeUso.editarTarea(TareaDTO)
                .flatMap(respuesta -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(respuesta)
                );
        return route(PUT("/tarea/editar").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TareaDTO.class)
                        .flatMap(editarTarea));
    }
}
