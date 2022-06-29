package co.com.sofkau.appagilismo.historiadeusuario.dto;

import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class HistoriaDeUsuarioDTO {
    private String historiaUsuarioId;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String liderTecnicoId;

    @NotBlank
    private String desarrolladorId;

    @NotBlank
    private String proyectoId;

    private List<TareaDTO> tareas;

    public HistoriaDeUsuarioDTO() {
    }

    public HistoriaDeUsuarioDTO(String historiaUsuarioId, String descripcion, String liderTecnicoId, String desarrolladorId , String proyectoId) {
        this.historiaUsuarioId = historiaUsuarioId;
        this.descripcion = descripcion;
        this.liderTecnicoId=liderTecnicoId;
        this.desarrolladorId=desarrolladorId;
        this.proyectoId=proyectoId;
    }

    public HistoriaDeUsuarioDTO(String descripcion, String liderTecnicoId, String desarrolladorId, String proyectoId) {
        this.descripcion = descripcion;
        this.liderTecnicoId=liderTecnicoId;
        this.desarrolladorId=desarrolladorId;
        this.proyectoId=proyectoId;
    }

    public String getHistoriaUsuarioId() {
        return historiaUsuarioId;
    }

    public void setHistoriaUsuarioId(String historiaUsuarioId) {
        this.historiaUsuarioId = historiaUsuarioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(String proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getLiderTecnicoId() {
        return liderTecnicoId;
    }

    public void setLiderTecnicoId(String liderTecnicoId) {
        this.liderTecnicoId = liderTecnicoId;
    }

    public String getDesarrolladorId() {
        return desarrolladorId;
    }

    public void setDesarrolladorId(String desarrolladorId) {
        this.desarrolladorId = desarrolladorId;
    }

    public List<TareaDTO> getTareas() {
        return tareas;
    }

    public void setTareas(List<TareaDTO> tareas) {
        this.tareas = tareas;
    }
}
