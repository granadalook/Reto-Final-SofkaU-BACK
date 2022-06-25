package co.com.sofkau.appagilismo.usuario.mapper;

import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;

import java.util.function.Function;

public class MapperUsuario {

    public Function<UsuarioDTO, Usuario> mapperAUsuario(String id){
        return updateUsuario -> {
            var usuario = new Usuario();
            usuario.setUsuarioId(id);
            usuario.setNombreCompleto(updateUsuario.getNombreCompleto());
            usuario.setEmail(updateUsuario.getEmail());
            usuario.setPassword(updateUsuario.getEmail());
            return usuario;
        };

    }

    public Function<Usuario, UsuarioDTO> mapperAUsuarioDTO(){
        return entity -> new UsuarioDTO(
                entity.getUsuarioId(),
                entity.getNombreCompleto(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}
