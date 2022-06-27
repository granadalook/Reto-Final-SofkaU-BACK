package co.com.sofkau.appagilismo.proyecto.dto;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class TareasDTO {
    private String tareasiId;

    @NotBlank
    private String nombreTarea;

    @NotBlank
    private boolean estadoTarea;

    private String descripcionTarea;

    private List<String> miembros;

    private String desarrolladorId;

    private String usuarioId;

    private List<String> historias_de_usuarios;

    public TareasDTO (){

    }

    public TareasDTO(String tareasiId, String nombreTarea, boolean estadoTarea) {
        this.tareasiId = tareasiId;
        this.nombreTarea = nombreTarea;
        this.estadoTarea = estadoTarea;
    }

    public TareasDTO(String tareasiId, String nombreTarea, boolean estadoTarea, String descripcionTarea, List<String> miembros, String desarrolladorId, String usuarioId, List<String> historias_de_usuarios) {
        this.tareasiId = tareasiId;
        this.nombreTarea = nombreTarea;
        this.estadoTarea = estadoTarea;
        this.descripcionTarea = descripcionTarea;
        this.miembros = miembros;
        this.desarrolladorId = desarrolladorId;
        this.usuarioId = usuarioId;
        this.historias_de_usuarios = historias_de_usuarios;
    }

    public TareasDTO(String tareasiId, String nombreTarea, boolean estadoTarea, String descripcionTarea, List<String> miembros, String desarrolladorId, String usuarioId) {
        this.tareasiId = tareasiId;
        this.nombreTarea = nombreTarea;
        this.estadoTarea = estadoTarea;
        this.descripcionTarea = descripcionTarea;
        this.miembros = miembros;
        this.desarrolladorId = desarrolladorId;
        this.usuarioId = usuarioId;
    }

    public String getTareasiId() {
        return tareasiId;
    }

    public void setTareasiId(String tareasiId) {
        this.tareasiId = tareasiId;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public boolean isEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(boolean estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public List<String> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<String> miembros) {
        this.miembros = miembros;
    }

    public String getDesarrolladorId() {
        return desarrolladorId;
    }

    public void setDesarrolladorId(String desarrolladorId) {
        this.desarrolladorId = desarrolladorId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<String> getHistorias_de_usuarios() {
        return historias_de_usuarios;
    }

    public void setHistorias_de_usuarios(List<String> historias_de_usuarios) {
        this.historias_de_usuarios = historias_de_usuarios;
    }
}
