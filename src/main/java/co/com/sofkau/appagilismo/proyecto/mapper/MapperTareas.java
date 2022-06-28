package co.com.sofkau.appagilismo.proyecto.mapper;

import co.com.sofkau.appagilismo.proyecto.coleccion.Tareas;
import co.com.sofkau.appagilismo.proyecto.dto.TareasDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperTareas {
    public Function <TareasDTO, Tareas> mapperATarea(){
        return tareaActualizada -> {
            var tarea = new Tareas();
            tarea.setNombreTarea(tareaActualizada.getNombreTarea());
            tarea.setEstadoTarea(tareaActualizada.isEstadoTarea());
            return tarea;
        };
    }
    public Function <Tareas, TareasDTO> mapperATareaDTO(){
        return tareaDTO -> new TareasDTO (
                tareaDTO.getTareasiId(),
                tareaDTO.getNombreTarea(),
                tareaDTO.isEstadoTarea()
        );
    }


}
