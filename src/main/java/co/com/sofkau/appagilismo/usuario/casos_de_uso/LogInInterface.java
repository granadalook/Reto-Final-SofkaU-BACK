package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioLogin;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface LogInInterface {
    Mono<UsuarioDTO> logIn(@Valid UsuarioLogin usuarioLogin);
}
