package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

/**
 * Clase que representa el caso de uso de actualizar un proyecto.
 */
@Service
@Validated
public class ActualizarProyectoCasoDeUso implements CrearProyectoInterface {

    private final ProyectoRepositorio repositorio;
    private final MapperProyecto mapperProyecto;

    public ActualizarProyectoCasoDeUso(ProyectoRepositorio repositorio, MapperProyecto mapperProyecto) {
        this.repositorio = repositorio;
        this.mapperProyecto = mapperProyecto;
    }

    /**
     * Metodo que permite actualizar un proyecto.
     * @param proyectoDTO
     * @return
     */
    @Override
    public Mono<ProyectoDTO> guardarProyecto(ProyectoDTO proyectoDTO) {
        return repositorio
                .save(mapperProyecto.mapperAProyecto(proyectoDTO.getProyectoId()).apply(proyectoDTO))
                .map(mapperProyecto.mapperAProyectoDTO());
    }
}