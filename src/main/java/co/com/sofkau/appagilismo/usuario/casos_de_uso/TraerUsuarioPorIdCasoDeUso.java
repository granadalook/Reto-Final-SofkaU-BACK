package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.casos_de_uso.TraerProyectoPorIdcasoDeUso;
import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.mapper.MapperUsuario;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class TraerUsuarioPorIdCasoDeUso implements TraerUsuarioPorIdInterface {

    private final UsuarioRepositorio usuarioRepositorio;
    private final MapperUsuario mapperUsuario;
    private final ProyectoRepositorio proyectoRepositorio;
    private final MapperProyecto mapperProyecto;
    private final TraerProyectoPorIdcasoDeUso traerProyectoPorIdcasoDeUso;

    public TraerUsuarioPorIdCasoDeUso(UsuarioRepositorio usuarioRepositorio, MapperUsuario mapperUsuario, ProyectoRepositorio proyectoRepositorio, MapperProyecto mapperProyecto, TraerProyectoPorIdcasoDeUso traerProyectoPorIdcasoDeUso) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.mapperUsuario = mapperUsuario;
        this.proyectoRepositorio = proyectoRepositorio;
        this.mapperProyecto = mapperProyecto;
        this.traerProyectoPorIdcasoDeUso = traerProyectoPorIdcasoDeUso;
    }

    public Mono<UsuarioDTO> traerUsuarioPorId(String id) {
        Objects.requireNonNull(id, "Id es requerido");
        return usuarioRepositorio.findById(id).map(mapperUsuario.mapperAUsuarioDTO());
                .flatMap(traerListaProyectos());
    }

    private Function<UsuarioDTO, Mono<UsuarioDTO>> traerListaProyectos() {
        List<ProyectoDTO> lista = new ArrayList<>();
        return usuarioDTO -> Mono.just(usuarioDTO)
                .zipWith(
                        (usuarioDTO.getIdProyectosAsociados()
                                .stream()
                                .forEach(proyectos -> lista.add(traerProyectoPorIdcasoDeUso.apply(usuarioDTO.getUsuarioId())))),
                        (usuario, listaProyectos) -> {
                            usuario.setProyectosAsociados(lista);
                            return usuario;
                        });
    }
}