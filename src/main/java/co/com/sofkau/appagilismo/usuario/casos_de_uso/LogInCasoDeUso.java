package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.excepciones.ExcepcionPersonalizadaInternalServerError;
import co.com.sofkau.appagilismo.excepciones.ExcepcionPersonalizadaNotFound;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioLogin;
import co.com.sofkau.appagilismo.usuario.mapper.MapperUsuario;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
@Validated
public class LogInCasoDeUso implements LogInInterface {
    private static final Logger log = LoggerFactory.getLogger(LogInCasoDeUso.class);

    private UsuarioRepositorio usuarioRepositorio;

    public LogInCasoDeUso(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Mono<UsuarioDTO> logIn(UsuarioLogin usuarioLogin) {

        return usuarioRepositorio.findByEmailAndPassword(usuarioLogin.getEmail(), usuarioLogin.getPassword())
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .onErrorResume(error -> {
                    if (error.getMessage().equals("404 NOT_FOUND")) {
                        return Mono.error(new ExcepcionPersonalizadaNotFound("Usuario no se encuentra registrado"));
                    }
                    return Mono.error(new ExcepcionPersonalizadaInternalServerError("Campos vacios o Formato de email invalido."));
                });
    }
}
