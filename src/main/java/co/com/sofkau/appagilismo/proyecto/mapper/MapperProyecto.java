package co.com.sofkau.appagilismo.proyecto.mapper;

import co.com.sofkau.appagilismo.proyecto.coleccion.Proyecto;
import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Clase que se encarga de mapear un proyecto de la base de datos a una respuesta de la clase
 * dto de la aplicacion o viceversa.
 */
@Component
public class MapperProyecto {

    /**
     * Metodo que se encarga de mapear un DTO de proyecto a la colección para que se guarde en la bse de datos.
     * @param id
     * @return Objeto de proyecto.
     */
    public Function<ProyectoDTO, Proyecto> mapperAProyecto(String id) {
        return proyectoActualizado -> {
            var proyecto = new Proyecto();
            proyecto.setProyectoId(id);
            proyecto.setNombre(proyectoActualizado.getNombre());
            proyecto.setArquitectoId(proyectoActualizado.getArquitectoId());
            proyecto.setLiderTecnicoId(proyectoActualizado.getLiderTecnicoId());
            proyecto.setPorcentajeDeAvance(proyectoActualizado.getPorcentajeDeAvance());
            proyecto.setEstado(proyectoActualizado.getEstado());
            return proyecto;
        };
    }

    /**
     * Metodo que se encarga de mapear desde la colección proyecto para transferir los datos al DTO.
     * @return Objeto ProyectoDTO
     */
    public Function<Proyecto, ProyectoDTO> mapperAProyectoDTO() {
        return proyectoDto -> new ProyectoDTO(
                proyectoDto.getProyectoId(),
                proyectoDto.getNombre(),
                proyectoDto.getArquitectoId(),
                proyectoDto.getLiderTecnicoId(),
                proyectoDto.getPorcentajeDeAvance(),
                proyectoDto.getEstado()
        );
    }

    public Function<ProyectoDTO, Proyecto> mapperAProyectoConDesarrollador(){
        return proyectoActualizado ->{
            var proyecto = new Proyecto();
            proyecto.setNombre(proyectoActualizado.getNombre());
            proyecto.setArquitectoId(proyectoActualizado.getArquitectoId());
            proyecto.setLiderTecnicoId(proyectoActualizado.getLiderTecnicoId());
            return proyecto;
        };
    }
}
