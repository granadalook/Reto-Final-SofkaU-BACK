package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * Interfaz funcional de asignar un usuario a un proyecto.
 */
@FunctionalInterface
public interface AsignarProyectoAUsuarioInterface {

    /**
     * Metodo que permite asignar un usuario a un proyecto.
     * @param usuarioDTO
     * @return Objeto de UsuarioDTO
     */
    Mono<UsuarioDTO> asignarProyecto(@Valid UsuarioDTO usuarioDTO);
}
