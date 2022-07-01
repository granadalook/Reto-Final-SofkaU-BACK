package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * Interfaz funcional de editar tarea.
 */
@FunctionalInterface
public interface EditarTareaInterface {

    /**
     * Metodo que permite editar una tarea.
     * @param tareaDTO
     * @return Objeto de Historia de usuario
     */
    Mono<HistoriaDeUsuarioDTO> editarTarea (@Valid TareaDTO tareaDTO);
}
