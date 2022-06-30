package co.com.sofkau.appagilismo.proyecto.mapper;

import co.com.sofkau.appagilismo.proyecto.coleccion.Proyecto;
import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperProyecto {

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
