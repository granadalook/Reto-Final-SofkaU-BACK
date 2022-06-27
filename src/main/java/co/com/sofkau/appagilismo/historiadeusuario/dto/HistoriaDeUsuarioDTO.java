package co.com.sofkau.appagilismo.historiadeusuario.dto;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class HistoriaDeUsuarioDTO {


    private String historiaUsuarioId;

    @NotBlank
    private String Descripcion;

    @NotBlank
    private String usuarioId;

    private List<String> tareas; // cambiar el String por tipo clase Tarea.

    public HistoriaDeUsuarioDTO() {
    }

    public HistoriaDeUsuarioDTO(String historiaUsuarioId, String descripcion, String usuarioId) {
        this.historiaUsuarioId = historiaUsuarioId;
        this.Descripcion = descripcion;
        this.usuarioId = usuarioId;
    }

    public HistoriaDeUsuarioDTO(String descripcion, String usuarioId) {
        this.Descripcion = descripcion;
        this.usuarioId = usuarioId;
    }

    public String getHistoriaUsuarioId() {
        return historiaUsuarioId;
    }

    public void setHistoriaUsuarioId(String historiaUsuarioId) {
        this.historiaUsuarioId = historiaUsuarioId;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
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
