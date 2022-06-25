package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.mapper.MapperUsuario;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class UsuarioCasosDeUsos implements Function<String, Mono<String>> {

    private final UsuarioRepositorio repositorio;
    private final MapperUsuario mapperUsuario;

    public UsuarioCasosDeUsos(UsuarioRepositorio repositorio, MapperUsuario mapperUsuario) {
        this.repositorio = repositorio;
        this.mapperUsuario = mapperUsuario;
    }

    @Override
    public Mono<String> apply(String s) {
        return Mono.just("Hola mundo");
    }
}
