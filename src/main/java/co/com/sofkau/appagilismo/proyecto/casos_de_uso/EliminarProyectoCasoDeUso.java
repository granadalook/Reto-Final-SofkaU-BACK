package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * Clase que representa el caso de uso de eliminar un proyecto por su Id.
 */
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

    /**
     * Metodo que permite eliminar un nuevo proyecto por su Id.
     * @param idProyecto
     * @return Mono<Void>
     */
    @Override
    public Mono<Void> deleteProyectoById(String idProyecto) {
        Objects.requireNonNull(idProyecto, "Id es requerido");
        return repositorio.deleteById(idProyecto)
                .switchIfEmpty(Mono.defer(() -> historiaDeUsuarioRepositorio.deleteByProyectoId(idProyecto)));
    }
}