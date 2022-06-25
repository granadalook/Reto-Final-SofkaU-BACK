package co.com.sofkau.appagilismo.usuario.casos_de_uso;


import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface LogInInterface {
    Mono<UsuarioDTO> logIn(@Valid UsuarioDTO usuarioDTO);
}
