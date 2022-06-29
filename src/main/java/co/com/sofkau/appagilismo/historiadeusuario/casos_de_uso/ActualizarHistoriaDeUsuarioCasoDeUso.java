package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class ActualizarHistoriaDeUsuarioCasoDeUso implements CrearHistoriaDeUsuarioInterface {

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    public ActualizarHistoriaDeUsuarioCasoDeUso(HistoriaDeUsuarioRepositorio repositorio, MapperHistoriaDeUsuario mapperHistoriaDeUsuario){
        this.repositorio=repositorio;
        this.mapperHistoriaDeUsuario=mapperHistoriaDeUsuario;
    }

    @Override
    public Mono<String> crearHistoriaDeUsuario(HistoriaDeUsuarioDTO historiaDeUsuarioDTO) {
        Objects.requireNonNull(historiaDeUsuarioDTO.getHistoriaUsuarioId(), "Id de la Historia De Usuario es requerido.");
        return repositorio.save(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuario(historiaDeUsuarioDTO.getHistoriaUsuarioId()).apply(historiaDeUsuarioDTO))
                .map(HistoriaDeUsuario::getHistoriaUsuarioId);
    }
}
