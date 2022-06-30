package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class ListarProyectosCasoDeUso implements Supplier<Flux<ProyectoDTO>> {

    private final ProyectoRepositorio repositorio;
    private final MapperProyecto mapperProyecto;

    public ListarProyectosCasoDeUso(ProyectoRepositorio repositorio, MapperProyecto mapperProyecto) {
        this.repositorio = repositorio;
        this.mapperProyecto = mapperProyecto;
    }

    @Override
    public Flux<ProyectoDTO> get() {
        return repositorio.findAll()
                .map(mapperProyecto.mapperAProyectoDTO());
    }
}