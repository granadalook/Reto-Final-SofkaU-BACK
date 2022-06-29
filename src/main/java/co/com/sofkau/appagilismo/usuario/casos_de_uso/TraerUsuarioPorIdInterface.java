package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface TraerUsuarioPorIdInterface {

    Mono<UsuarioDTO> traerUsuarioPorId(String id);
}
