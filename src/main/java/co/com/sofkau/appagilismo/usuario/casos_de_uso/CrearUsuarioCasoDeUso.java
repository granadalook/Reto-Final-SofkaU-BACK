package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
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
import reactor.core.publisher.Mono;


@Service
@Validated
public class CrearUsuarioCasoDeUso implements CrearUsuarioInterface {

    private static final Logger log = LoggerFactory.getLogger(CrearUsuarioCasoDeUso.class);
    @Autowired
    private EnviarMail enviarMail;
    private final UsuarioRepositorio repositorio;
    private final MapperUsuario mapperUsuario;

    public CrearUsuarioCasoDeUso(UsuarioRepositorio repositorio, MapperUsuario mapperUsuario) {
        this.repositorio = repositorio;
        this.mapperUsuario = mapperUsuario;
    }


    @Override
    public Mono<UsuarioDTO> crearUsuario(UsuarioDTO usuarioDTO) {
        return repositorio.save(mapperUsuario.mapperAUsuario().apply(usuarioDTO))
                .map(usuario -> {
                            try {
                                enviarMail.enviarEmail(usuario.getEmail(),
                                        "Datos de ingreso a la app de gestor de agilismo: ",
                                        "Su usuario es: " + usuario.getEmail() + "\n" +
                                                "Su contraseña es: " + usuario.getPassword() + "\n" +
                                                "Url de inicio de sesión: https://cilantroagile.web.app/ ");

                            } catch (Exception e) {
                                throw new RuntimeException("No se pudo enviar el correo");
                            }
                            return mapperUsuario.mapperAUsuarioDTO().apply(usuario);
                        }
                )
                .onErrorResume(error -> {
                    if(error.equals(HttpStatus.NOT_FOUND)){
                        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND));
                    }
                    return Mono.error(new RuntimeException("Email ya existente"));
                });

    }

}