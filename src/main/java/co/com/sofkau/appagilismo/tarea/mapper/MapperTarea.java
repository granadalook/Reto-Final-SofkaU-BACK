package co.com.sofkau.appagilismo.tarea.mapper;

import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Clase que se encarga de mapear una tarea de la base de datos a una respuesta de la clase
 * dto de la aplicacion o viceversa.
 */
@Component
public class MapperTarea {

    /**
     * Metodo que se encarga de mapear un DTO de tarea a la colección para que se guarde en la bse de datos.
     * @param tareaId
     * @return Objeto de Tarea.
     */
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

    /**
     * Metodo que se encarga de mapear desde la colección tarea para transferir los datos al DTO.
     * @return Objeto de TareaDTO
     */
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
