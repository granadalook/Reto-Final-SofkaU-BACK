package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.mapper.MapperUsuario;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.Supplier;

@Service
@Validated
public class ListarUsuariosPorRolCasoDeUso implements Function<String,Flux<UsuarioDTO>> {

    private final UsuarioRepositorio repositorio;

    private final MapperUsuario mapperUsuario;

    public ListarUsuariosPorRolCasoDeUso(MapperUsuario mapperUsuario, UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
        this.mapperUsuario=mapperUsuario;
    }


    @Override
    public Flux<UsuarioDTO> apply(String rol) {
        return repositorio.findAllByRol(rol)
                .map(mapperUsuario.mapperAUsuarioDTO());
    }
}
