package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CrearHistoriaDeUsuarioCasoDeUso implements CrearHistoriaDeUsuarioInterface{

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    public CrearHistoriaDeUsuarioCasoDeUso(HistoriaDeUsuarioRepositorio repositorio, MapperHistoriaDeUsuario mapperHistoriaDeUsuario){
        this.repositorio=repositorio;
        this.mapperHistoriaDeUsuario=mapperHistoriaDeUsuario;
    }

    @Override
    public Mono<HistoriaDeUsuarioDTO> crearHistoriaDeUsuario(HistoriaDeUsuarioDTO historiaDeUsuarioDTO){
        return repositorio
                .save(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuario().apply(historiaDeUsuarioDTO))
                .map(historiaDeUsuario -> mapperHistoriaDeUsuario.mapperAHistoriaDeUsuarioDTO().apply(historiaDeUsuario));
    }

}
