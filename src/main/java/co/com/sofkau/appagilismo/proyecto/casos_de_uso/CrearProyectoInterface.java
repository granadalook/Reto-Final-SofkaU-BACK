package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface CrearProyectoInterface {

    Mono<ProyectoDTO> guardarProyecto(@Valid ProyectoDTO proyectoDTO);
}
