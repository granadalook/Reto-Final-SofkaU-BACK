package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class ActualizarProyectoCasoDeUso implements CrearProyectoInterface {

    private final ProyectoRepositorio repositorio;
    private final MapperProyecto mapperProyecto;

    public ActualizarProyectoCasoDeUso(ProyectoRepositorio repositorio, MapperProyecto mapperProyecto) {
        this.repositorio = repositorio;
        this.mapperProyecto = mapperProyecto;
    }

    @Override
    public Mono<ProyectoDTO> guardarProyecto(ProyectoDTO proyectoDTO) {
        return repositorio
                .save(mapperProyecto.mapperAProyecto(proyectoDTO.getProyectoId()).apply(proyectoDTO))
                .map(mapperProyecto.mapperAProyectoDTO());
    }
}