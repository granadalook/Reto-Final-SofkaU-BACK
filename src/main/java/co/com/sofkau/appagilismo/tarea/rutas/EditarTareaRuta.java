package co.com.sofkau.appagilismo.tarea.rutas;

import co.com.sofkau.appagilismo.tarea.casos_de_uso.CrearTareaCasoDeUso;
import co.com.sofkau.appagilismo.tarea.casos_de_uso.EditarTareaCasoDeUso;
import co.com.sofkau.appagilismo.tarea.casos_de_uso.EliminarTareaCasoDeUso;
import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EditarTareaRuta {
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
