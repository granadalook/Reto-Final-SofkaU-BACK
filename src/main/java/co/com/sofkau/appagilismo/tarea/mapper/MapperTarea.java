package co.com.sofkau.appagilismo.tarea.mapper;

import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperTarea {

    public Function<TareaDTO, Tarea> mapperATarea(String tareaId){
        return tareaActualizada -> {
            var tarea = new Tarea();
            tarea.setTareaId(tareaId);
            tarea.setDesarrolladorId(tareaActualizada.getDesarrolladorId());
            tarea.setNombreTarea(tareaActualizada.getNombreTarea());
            tarea.setEstado(tareaActualizada.getEstado());
            tarea.setCompleta(tareaActualizada.isCompleta());
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
                tarea.getEstado(),
                tarea.isCompleta(),
                tarea.getDescripcionTarea(),
                tarea.getHistoriaUsuarioId()
        );
    }
}
