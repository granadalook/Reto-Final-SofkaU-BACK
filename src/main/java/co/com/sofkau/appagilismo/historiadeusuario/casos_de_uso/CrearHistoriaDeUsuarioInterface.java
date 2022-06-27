package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface CrearHistoriaDeUsuarioInterface {

    Mono<HistoriaDeUsuarioDTO> crearHistoriaDeUsuario(@Valid HistoriaDeUsuarioDTO historiaDeUsuarioDTO);
}
