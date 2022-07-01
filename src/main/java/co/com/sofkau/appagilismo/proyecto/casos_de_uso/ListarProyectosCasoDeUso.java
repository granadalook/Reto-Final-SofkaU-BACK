package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

/**
 * Clase que representa el caso de uso de traer todos los proyectos almacenados en la base de datos.
 */
@Service
@Validated
public class ListarProyectosCasoDeUso implements Supplier<Flux<ProyectoDTO>> {

    private final ProyectoRepositorio repositorio;
    private final MapperProyecto mapperProyecto;

    public ListarProyectosCasoDeUso(ProyectoRepositorio repositorio, MapperProyecto mapperProyecto) {
        this.repositorio = repositorio;
        this.mapperProyecto = mapperProyecto;
    }

    /**
     * Metodo que permite traer una lista de proyectos almacenados en la base de datos.
     * @return Lista de objetos de ProyectosDTO
     */
    @Override
    public Flux<ProyectoDTO> get() {
        return repositorio.findAll()
                .map(mapperProyecto.mapperAProyectoDTO());
    }
}