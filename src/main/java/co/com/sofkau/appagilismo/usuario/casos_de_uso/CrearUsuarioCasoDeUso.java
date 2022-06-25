package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import co.com.sofkau.appagilismo.usuario.utilidades.EnviarMail;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CrearUsuarioCasoDeUso implements CrearUsuario{

    private final UsuarioRepositorio repositorio;
    private final EnviarMail enviarMail;
    private final MapperUsuario mapperUsuario;

    public CrearUsuarioCasoDeUso(UsuarioRepositorio repositorio, EnviarMail enviarMail, MapperUsuario mapperUsuario) {
        this.repositorio = repositorio;
        this.enviarMail = enviarMail;
        this.mapperUsuario = mapperUsuario;
    }


    @Override
    public Mono<UsuarioDTO> crearUsuario(UsuarioDTO usuarioDTO) {
        return repositorio
                .save(mapperUsuario.mapperAUsuario.apply(usuarioDTO))
                .map(resultado -> {
                            try {
                                enviarMail.enviarEmail(usuarioDTO.getEmail,
                                        "Datos de ingreso a la app de gestor de agilismo: ",
                                        "Su usuario es: " +usuarioDTO.getEmail+ "\n" +
                                                       "Su contraseña es: " +usuarioDTO.getPassword+ "\n" +
                                                        "Url de inicio de sesión: " );
                            } catch (Exception e) {

                            }
                            return mapperUsuario.mapperAUsuarioDTO;;
                        }

                );
    }
}