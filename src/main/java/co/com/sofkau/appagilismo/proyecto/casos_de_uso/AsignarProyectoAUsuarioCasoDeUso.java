package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.mapper.MapperUsuario;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el caso de uso de asignar un proyecto a un usuario.
 */
@Service
@Validated
public class AsignarProyectoAUsuarioCasoDeUso implements AsignarProyectoAUsuarioInterface {

    private final UsuarioRepositorio repositorio;
    private final MapperUsuario mapperUsuario;

    public AsignarProyectoAUsuarioCasoDeUso(UsuarioRepositorio repositorio, MapperUsuario mapperUsuario) {
        this.repositorio = repositorio;
        this.mapperUsuario = mapperUsuario;
    }

    /**
     * Metodo que permite asignar un proyecto a un usuario.
     * @param usuarioDTO
     * @return Objeto de UsuarioDTO
     */
    @Override
    public Mono<UsuarioDTO> asignarProyecto(UsuarioDTO usuarioDTO) {
        return repositorio.findById(usuarioDTO.getUsuarioId())
                .flatMap(usuario -> {
                    String idProyecto = usuarioDTO.getIdProyectosAsociados().get(0);
                    List<String> lista = new ArrayList<>();
                    lista = usuario.getIdProyectosAsociados();
                    lista.add(idProyecto);
                    usuario.setIdProyectosAsociados(lista);
                    return repositorio.save(usuario);
                })
                .map(mapperUsuario.mapperAUsuarioDTO());
    }
}