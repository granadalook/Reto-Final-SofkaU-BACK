package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * Interfaz funcional de crear una historia de usuario.
 */
@FunctionalInterface
public interface CrearHistoriaDeUsuarioInterface {

    /**
     * Metodo que permite crear una historia de usuario.
     * @param historiaDeUsuarioDTO
     * @return
     */
    Mono<HistoriaDeUsuarioDTO> crearHistoriaDeUsuario(@Valid HistoriaDeUsuarioDTO historiaDeUsuarioDTO);
}
