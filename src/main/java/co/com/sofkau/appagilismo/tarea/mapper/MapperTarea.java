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
            tarea.setDesarrolladorId(tareaActualizada.getDesarrolladorId());
            tarea.setNombreTarea(tareaActualizada.getNombreTarea());
            tarea.setEstadoTarea(tareaActualizada.isEstadoTarea());
            tarea.setDescripcionTarea(tareaActualizada.getDescripcionTarea());
            tarea.setHistoriaUsuarioId(tareaActualizada.getHistoriaUsuarioId());
            return tarea;
        };
    }

    public  Function<Tarea,TareaDTO> mapperATareaDTO(){
        return tarea -> new TareaDTO(
                tarea.getTareaId(),
                tarea.getDesarrolladorId(),
                tarea.getNombreTarea(),
                tarea.isEstadoTarea(),
                tarea.getDescripcionTarea(),
                tarea.getHistoriaUsuarioId()
        );
    }



}
