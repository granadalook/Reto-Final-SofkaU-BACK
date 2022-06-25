package co.com.sofkau.appagilismo.usuario.mapper;

import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUsuario {

    public Function<UsuarioDTO, Usuario> mapperAUsuario(){
        return updateUsuario -> {
            var usuario = new Usuario();
            usuario.setNombreCompleto(updateUsuario.getNombreCompleto());
            usuario.setEmail(updateUsuario.getEmail());
            usuario.setPassword(updateUsuario.getPassword());
            usuario.setRol(updateUsuario.getRol());
            return usuario;
        };
    }

    public Function<Usuario, UsuarioDTO> mapperAUsuarioDTO(){
        return entity -> new UsuarioDTO(
                entity.getUsuarioId(),
                entity.getNombreCompleto(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRol()
        );
    }
}
