package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

/**
 * Clase que representa el caso de uso de crear un proyecto.
 */
@Service
@Validated
public class CrearProyectoCasoDeUso implements CrearProyectoInterface{

    private final ProyectoRepositorio repositorio;
    private final MapperProyecto mapperProyecto;

    public CrearProyectoCasoDeUso(ProyectoRepositorio repositorio, MapperProyecto mapperProyecto) {
        this.repositorio = repositorio;
        this.mapperProyecto = mapperProyecto;
    }

    /**
     * Metodo que permite crear un nuevo proyecto.
     * @param proyectoDTO
     * @return Objecto de ProyectoDTO.
     */
    @Override
    public Mono<ProyectoDTO> guardarProyecto(ProyectoDTO proyectoDTO) {
        return
                repositorio
                .save(mapperProyecto.mapperAProyecto(null).apply(proyectoDTO))
                .map(proyecto -> mapperProyecto.mapperAProyectoDTO().apply(proyecto));
    }
}
