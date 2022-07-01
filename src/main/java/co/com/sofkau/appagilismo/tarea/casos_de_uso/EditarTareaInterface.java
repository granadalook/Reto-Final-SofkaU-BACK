package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface EditarTareaInterface {
    Mono<TareaDTO> editarTarea (@Valid TareaDTO tareaDTO);

}
