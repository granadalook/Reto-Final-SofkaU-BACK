package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioLogin;
import co.com.sofkau.appagilismo.usuario.mapper.MapperUsuario;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;

import co.com.sofkau.appagilismo.usuario.utilidades.EnviarMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class LogInCasoDeUso implements LogInInterface{
    private static final Logger log = LoggerFactory.getLogger(LogInCasoDeUso.class);

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    private final MapperUsuario mapperUsuario;

    public LogInCasoDeUso(UsuarioRepositorio usuarioRepositorio, MapperUsuario mapperUsuario) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.mapperUsuario = mapperUsuario;
    }

    public Mono<UsuarioDTO> logIn(UsuarioLogin usuarioLogin) {
        Objects.requireNonNull(usuarioLogin.getEmail(), "El email es obligatorio.");
        Objects.requireNonNull(usuarioLogin.getPassword(), "La contraseña es obligatoria.");

        return usuarioRepositorio.findByEmail(usuarioLogin.getEmail())
                .filter(objeto -> objeto.getEmail().equals(usuarioLogin.getEmail()) && objeto.getPassword().equals(usuarioLogin.getPassword()))
                .switchIfEmpty(Mono.error(new RuntimeException("El usuario no esta registrado.")));
    }

}
