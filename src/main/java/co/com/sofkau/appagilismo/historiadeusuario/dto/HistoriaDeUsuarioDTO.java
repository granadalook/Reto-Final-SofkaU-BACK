package co.com.sofkau.appagilismo.historiadeusuario.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class HistoriaDeUsuarioDTO {


    private String historiaUsuarioId;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String usuarioId;

    @NotBlank
    private String proyectoId;

    private List<String> tareas; // cambiar el String por tipo clase Tarea.

    public HistoriaDeUsuarioDTO() {
    }

    public HistoriaDeUsuarioDTO(String historiaUsuarioId, String descripcion, String usuarioId, String proyectoId) {
        this.historiaUsuarioId = historiaUsuarioId;
        this.descripcion = descripcion;
        this.usuarioId = usuarioId;
        this.proyectoId=proyectoId;
    }

    public HistoriaDeUsuarioDTO(String descripcion, String usuarioId, String proyectoId) {
        this.descripcion = descripcion;
        this.usuarioId = usuarioId;
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

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<String> getTareas() {
        return tareas;
    }

    public void setTareas(List<String> tareas) {
        this.tareas = tareas;
    }
}
