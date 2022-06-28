package co.com.sofkau.appagilismo.tarea.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class TareaDTO {

    private String tareaId;

    @NotBlank
    private String desarrolladorId;

    @NotBlank
    private String nombreTarea;

    @NotBlank
    private boolean estadoTarea;

    @NotBlank
    private String descripcionTarea;

    @NotBlank
    private List<String> historias_de_usuarios;

    public TareaDTO (){

    }

    public TareaDTO(String desarrolladorId, String nombreTarea, boolean estadoTarea, String descripcionTarea, List<String> historias_de_usuarios) {
        this.desarrolladorId = desarrolladorId;
        this.nombreTarea = nombreTarea;
        this.estadoTarea = estadoTarea;
        this.descripcionTarea = descripcionTarea;
        this.historias_de_usuarios = historias_de_usuarios;
    }

    public TareaDTO(String desarrolladorId, String nombreTarea, boolean estadoTarea, String descripcionTarea) {
        this.desarrolladorId = desarrolladorId;
        this.nombreTarea = nombreTarea;
        this.estadoTarea = estadoTarea;
        this.descripcionTarea = descripcionTarea;
    }

    public String getTareaId() {
        return tareaId;
    }

    public void setTareaId(String tareaId) {
        this.tareaId = tareaId;
    }

    public String getDesarrolladorId() {
        return desarrolladorId;
    }

    public void setDesarrolladorId(String desarrolladorId) {
        this.desarrolladorId = desarrolladorId;
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

    public List<String> getHistorias_de_usuarios() {
        return historias_de_usuarios;
    }

    public void setHistorias_de_usuarios(List<String> historias_de_usuarios) {
        this.historias_de_usuarios = historias_de_usuarios;
    }
}

