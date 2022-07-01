package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Clase que representa el caso de uso de traer un proyecto por su Id.
 */
@Service
@Validated
public class TraerProyectoPorIdcasoDeUso implements Function<String, Mono<ProyectoDTO>> {

    private final ProyectoRepositorio repositorio;
    private final MapperProyecto mapperProyecto;

    public TraerProyectoPorIdcasoDeUso(ProyectoRepositorio repositorio, MapperProyecto mapperProyecto) {
        this.repositorio = repositorio;
        this.mapperProyecto = mapperProyecto;
    }

    /**
     * Metodo que permite traer un proyecto por su Id.
     * @param idProyecto the function argument
     * @return Objeto de ProyectoDTO
     */
    @Override
    public Mono<ProyectoDTO> apply(String idProyecto) {
        return repositorio.findById(idProyecto)
                .map(mapperProyecto.mapperAProyectoDTO());
    }
}