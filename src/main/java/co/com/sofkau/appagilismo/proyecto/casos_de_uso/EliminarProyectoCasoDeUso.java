package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class EliminarProyectoCasoDeUso implements EliminarCasoDeUsoInterface {

    private final ProyectoRepositorio repositorio;
    private final HistoriaDeUsuarioRepositorio historiaDeUsuarioRepositorio;
    private final MapperProyecto mapperProyecto;

    public EliminarProyectoCasoDeUso(ProyectoRepositorio repositorio, HistoriaDeUsuarioRepositorio historiaDeUsuarioRepositorio, MapperProyecto mapperProyecto) {
        this.repositorio = repositorio;
        this.historiaDeUsuarioRepositorio = historiaDeUsuarioRepositorio;
        this.mapperProyecto = mapperProyecto;
    }

    @Override
    public Mono<Void> eliminarProyecto(String idProyecto) {
        Objects.requireNonNull(idProyecto, "Id es requerido");
        return repositorio.deleteById(idProyecto)
                .switchIfEmpty(Mono.defer(() -> historiaDeUsuarioRepositorio.deleteByProyectoId(idProyecto)));
    }
}