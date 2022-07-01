package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface CrearTareaInterface {
    Mono<HistoriaDeUsuarioDTO> crearTarea (@Valid TareaDTO tareaDTO);
}
