package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * Interfaz funcional de crear tarea.
 */
@FunctionalInterface
public interface CrearTareaInterface {

    /**
     * Metodo que permite crear una tarea.
     * @param tareaDTO
     * @return Objeto de historia de usuario
     */
    Mono<HistoriaDeUsuarioDTO> crearTarea (@Valid TareaDTO tareaDTO);
}
