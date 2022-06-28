package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;


@Service
@Validated
public class CrearTareaCasoDeUso implements CrearTareaInterface {
    @Autowired
    private TareaRepositorio tareaRepositorio;
    @Autowired
    private MapperTarea mapperTarea;

    public CrearTareaCasoDeUso(TareaRepositorio tareaRepositorio, MapperTarea mapperTarea) {
        this.tareaRepositorio = tareaRepositorio;
        this.mapperTarea = mapperTarea;
    }

    @Override
    public Mono<TareaDTO> crearTarea(TareaDTO tareaDTO) {
        return tareaRepositorio
                .save(mapperTarea.mapperATarea().apply(tareaDTO))
                .map(tarea -> mapperTarea.mapperATareaDTO().apply(tarea));
    }
}
