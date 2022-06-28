package co.com.sofkau.appagilismo.tarea.mapper;

import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperTarea {
    /*
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
     */
    public Function<TareaDTO, Tarea> mapperATarea(){
        return tareaActualizada -> {
            var tarea = new Tarea();
            tareaActualizada.getDesarrolladorId();
            tareaActualizada.getNombreTarea();
            tareaActualizada.isEstadoTarea();
            tareaActualizada.getDescripcionTarea();
            return tarea;
        };
    }

    public  Function<Tarea,TareaDTO> mapperATareaDTO(){
        return tareaDTO -> new TareaDTO(
                tareaDTO.getDesarrolladorId(),
                tareaDTO.getNombreTarea(),
                tareaDTO.isEstadoTarea(),
                tareaDTO.getDescripcionTarea()
        );
    }



}
