package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class ListarHistoriasDeUsuarioCasoDeUso implements Supplier<Flux<HistoriaDeUsuarioDTO>> {

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    public ListarHistoriasDeUsuarioCasoDeUso(MapperHistoriaDeUsuario mapperHistoriaDeUsuario, HistoriaDeUsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
        this.mapperHistoriaDeUsuario=mapperHistoriaDeUsuario;
    }

    @Override
    public Flux<HistoriaDeUsuarioDTO> get() {
        return repositorio.findAll()
                .map(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuarioDTO());
    }
}
