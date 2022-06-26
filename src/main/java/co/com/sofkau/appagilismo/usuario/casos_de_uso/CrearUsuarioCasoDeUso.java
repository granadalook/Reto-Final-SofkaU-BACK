package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.mapper.MapperUsuario;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import co.com.sofkau.appagilismo.usuario.rutas.excepciones.ExcepcionCampoEmailVacio;
import co.com.sofkau.appagilismo.usuario.rutas.excepciones.ExcepcionCampoNombreCompletoVacio;
import co.com.sofkau.appagilismo.usuario.utilidades.EnviarMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class CrearUsuarioCasoDeUso implements CrearUsuarioInterface {

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
        //Objects.requireNonNull(usuarioDTO.getEmail(), "El correo es obligatorio");
        //Objects.requireNonNull(usuarioDTO.getNombreCompleto());

        return repositorio
                .save(mapperUsuario.mapperAUsuario().apply(usuarioDTO))
                .map(usuario -> {
                        try {
                                enviarMail.enviarEmail(usuario.getEmail(),
                                        "Datos de ingreso a la app de gestor de agilismo: ",
                                        "Su usuario es: " + usuario.getEmail() + "\n" +
                                                "Su contraseña es: " + usuario.getPassword() + "\n" +
                                                "Url de inicio de sesión: ");

                            } catch (Exception e) {
                                System.out.println("No se pudo enviar correo");
                            }
                            return mapperUsuario.mapperAUsuarioDTO().apply(usuario);
                        }
                ).onErrorResume(error -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST)));
    }
}