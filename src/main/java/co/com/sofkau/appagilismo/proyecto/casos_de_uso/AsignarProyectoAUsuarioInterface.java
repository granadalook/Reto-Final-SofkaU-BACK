package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface AsignarProyectoAUsuarioInterface {

    Mono<UsuarioDTO> asignarProyecto(@Valid UsuarioDTO usuarioDTO);
}
