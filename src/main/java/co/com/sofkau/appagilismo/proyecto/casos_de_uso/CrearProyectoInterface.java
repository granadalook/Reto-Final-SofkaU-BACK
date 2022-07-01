package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * Interfaz funcional de crear proyecto.
 */
@FunctionalInterface
public interface CrearProyectoInterface {

    /**
     * Metodo que permite crear un proyecto.
     * @param proyectoDTO
     * @return Objeto de ProyectoDTO
     */
    Mono<ProyectoDTO> guardarProyecto(@Valid ProyectoDTO proyectoDTO);
}
