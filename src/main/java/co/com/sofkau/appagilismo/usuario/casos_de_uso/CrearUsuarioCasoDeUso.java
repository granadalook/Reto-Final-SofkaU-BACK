package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.mapper.MapperUsuario;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import co.com.sofkau.appagilismo.usuario.utilidades.EnviarMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
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
                                                   "Url de inicio de sesión: ");

                               } catch (Exception e) {
                                   System.out.println("No se pudo enviar correo");
                               }
                               return mapperUsuario.mapperAUsuarioDTO().apply(usuario);
                           }
                   ).onErrorResume(error -> Mono.error(new RuntimeException("Campos vacios o Email ya existente.")));

    }

}