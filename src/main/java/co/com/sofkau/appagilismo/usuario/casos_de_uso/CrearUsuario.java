package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CrearUsuario {

    Mono<UsuarioDTO> crearUsuario(@Validated UsuarioDTO usuarioDTO);
}
