package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class AsignarProyectoAUsuarioCasoDeUso implements AsignarProyectoAUsuarioInterface {

    private final UsuarioRepositorio repositorio;
    private final MapperProyecto mapperProyecto;

    public AsignarProyectoAUsuarioCasoDeUso(UsuarioRepositorio repositorio, MapperProyecto mapperProyecto) {
        this.repositorio = repositorio;
        this.mapperProyecto = mapperProyecto;
    }

    @Override
    public Mono<Void> asignarProyecto(String usuarioId, String proyectoId) {
        List<String> listaId = new ArrayList<>();
        listaId.add(proyectoId);
        return repositorio.findById(usuarioId)
                .map(usuario -> usuario.setIdProyectosAsociados(listaId));
    }
}
