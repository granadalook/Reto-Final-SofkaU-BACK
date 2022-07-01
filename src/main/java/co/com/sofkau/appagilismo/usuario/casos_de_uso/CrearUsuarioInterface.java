package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface CrearUsuarioInterface {

    Mono<UsuarioDTO> crearUsuario(@Valid UsuarioDTO usuarioDTO);
}
