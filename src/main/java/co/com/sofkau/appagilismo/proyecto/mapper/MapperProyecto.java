package co.com.sofkau.appagilismo.proyecto.mapper;

import co.com.sofkau.appagilismo.proyecto.coleccion.Proyecto;
import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperProyecto {

    public Function<ProyectoDTO, Proyecto> mapperAProyecto() {
        return proyectoActualizado -> {
            var proyecto = new Proyecto();
            proyecto.setNombre(proyectoActualizado.getNombre());
            proyecto.setArquitectoId(proyectoActualizado.getArquitectoId());
            proyecto.setLiderTecnicoId(proyectoActualizado.getLiderTecnicoId());
            return proyecto;
        };
    }

    public Function<Proyecto, ProyectoDTO> mapperAProyectoDTO() {
        return proyectoDto -> new ProyectoDTO(
                proyectoDto.getProyectoId(),
                proyectoDto.getNombre(),
                proyectoDto.getArquitectoId(),
                proyectoDto.getLiderTecnicoId(),
                proyectoDto.getDesarrolladorId()
        );
    }

    public Function<ProyectoDTO, Proyecto> mapperAProyectoConDesarrollador(){
        return proyectoActualizado ->{
            var proyecto = new Proyecto();
            proyecto.setNombre(proyectoActualizado.getNombre());
            proyecto.setArquitectoId(proyectoActualizado.getArquitectoId());
            proyecto.setLiderTecnicoId(proyectoActualizado.getLiderTecnicoId());
            proyecto.setDesarrolladorId(proyectoActualizado.getUsuarios());
            return proyecto;
        };
    }
}
