package co.com.sofkau.appagilismo.historiadeusuario.mapper;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.utilidades.CalcularPorcentajeDeAvance;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Clase que se encarga de mapear una historia de usuario de la base de datos a una respuesta de la clase
 * dto de la aplicacion o viceversa.
 */
@Component
public class MapperHistoriaDeUsuario {

    private CalcularPorcentajeDeAvance calcularPorcentajeDeAvance = new CalcularPorcentajeDeAvance();

    /**
     * Metodo que se encarga de mapear un DTO de historia de usuario a la colección para que se guarde en la bse de datos.
     * @param id
     * @return Objeto de Historia de usuario.
     */
    public Function<HistoriaDeUsuarioDTO, HistoriaDeUsuario> mapperAHistoriaDeUsuario(String id){
        return updateHistoriaDeUsuario -> {
            var historiaDeUsuario = new HistoriaDeUsuario();
            historiaDeUsuario.setHistoriaUsuarioId(id);
            historiaDeUsuario.setTituloHistoriaUsuario(updateHistoriaDeUsuario.getTituloHistoriaUsuario());
            historiaDeUsuario.setDescripcion(updateHistoriaDeUsuario.getDescripcion());
            historiaDeUsuario.setEstimacion(updateHistoriaDeUsuario.getEstimacion());
            historiaDeUsuario.setEstado(updateHistoriaDeUsuario.getEstado());
            historiaDeUsuario.setPorcentajeDeAvance(calcularPorcentajeDeAvance.calcularPorcentajeDeAvance(updateHistoriaDeUsuario));
            historiaDeUsuario.setLiderTecnicoId(updateHistoriaDeUsuario.getLiderTecnicoId());
            historiaDeUsuario.setDesarrolladorId(updateHistoriaDeUsuario.getDesarrolladorId());
            historiaDeUsuario.setProyectoId(updateHistoriaDeUsuario.getProyectoId());
            return historiaDeUsuario;
        };
    }

    /**
     * Metodo que se encarga de mapear un DTO de historia de usuario a la colección para que se guarde en la bse de datos.
     * @return Objeto de Historia de usuario.
     */
    public Function<HistoriaDeUsuario, HistoriaDeUsuarioDTO> mapperAHistoriaDeUsuarioDTO(){
        return entity -> new HistoriaDeUsuarioDTO(
                entity.getHistoriaUsuarioId(),
                entity.getTituloHistoriaUsuario(),
                entity.getDescripcion(),
                entity.getEstimacion(),
                entity.getEstado(),
                entity.getPorcentajeDeAvance(),
                entity.getLiderTecnicoId(),
                entity.getDesarrolladorId(),
                entity.getProyectoId()
        );
    }
}
