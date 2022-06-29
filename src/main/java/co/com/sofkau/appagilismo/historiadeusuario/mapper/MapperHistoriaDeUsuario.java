package co.com.sofkau.appagilismo.historiadeusuario.mapper;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class MapperHistoriaDeUsuario {

    public Function<HistoriaDeUsuarioDTO, HistoriaDeUsuario> mapperAHistoriaDeUsuario(){
        return updateHistoriaDeUsuario -> {
            var historiaDeUsuario = new HistoriaDeUsuario();
            historiaDeUsuario.setTituloHistoriaUsuario(updateHistoriaDeUsuario.getTituloHistoriaUsuario());
            historiaDeUsuario.setDescripcion(updateHistoriaDeUsuario.getDescripcion());
            historiaDeUsuario.setEstimacion(updateHistoriaDeUsuario.getEstimacion());
            historiaDeUsuario.setLiderTecnicoId(updateHistoriaDeUsuario.getLiderTecnicoId());
            historiaDeUsuario.setDesarrolladorId(updateHistoriaDeUsuario.getDesarrolladorId());
            historiaDeUsuario.setProyectoId(updateHistoriaDeUsuario.getProyectoId());
            return historiaDeUsuario;
        };
    }

    public Function<HistoriaDeUsuario, HistoriaDeUsuarioDTO> mapperAHistoriaDeUsuarioDTO(){
        return entity -> new HistoriaDeUsuarioDTO(
                entity.getHistoriaUsuarioId(),
                entity.getTituloHistoriaUsuario(),
                entity.getDescripcion(),
                entity.getEstimacion(),
                entity.getLiderTecnicoId(),
                entity.getDesarrolladorId(),
                entity.getProyectoId()
        );
    }

}
