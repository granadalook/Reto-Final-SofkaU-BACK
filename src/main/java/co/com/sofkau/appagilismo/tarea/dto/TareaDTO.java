package co.com.sofkau.appagilismo.tarea.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class TareaDTO {

    private String tareaId;

    @NotBlank(message = "Debe existir el desarrolladorId para este objeto.")
    private String desarrolladorId;

    @NotBlank
    private String nombreTarea;

    private boolean estadoTarea;

    @NotBlank
    private String descripcionTarea;

    @NotBlank
    private String historiaUsuarioId;

    public TareaDTO() {
    }

    public TareaDTO(String tareaId,String desarrolladorId, String nombreTarea, boolean estadoTarea, String descripcionTarea, String historiaUsuarioId) {
        this.tareaId = tareaId;
        this.desarrolladorId=desarrolladorId;
        this.nombreTarea = nombreTarea;
        this.estadoTarea = estadoTarea;
        this.descripcionTarea = descripcionTarea;
        this.historiaUsuarioId = historiaUsuarioId;
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

    public String getHistoriaUsuarioId() {
        return historiaUsuarioId;
    }

    public void setHistoriaUsuarioId(String historiaUsuarioId) {
        this.historiaUsuarioId = historiaUsuarioId;
    }

    public String getTareaId() {
        return tareaId;
    }

    public void setTareaId(String tareaId) {
        this.tareaId = tareaId;
    }
}

