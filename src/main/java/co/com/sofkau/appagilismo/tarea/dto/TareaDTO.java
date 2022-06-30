package co.com.sofkau.appagilismo.tarea.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class TareaDTO {

    private String tareaId;

    @NotBlank(message = "Debe existir el desarrolladorId para este objeto.")
    private String desarrolladorId;

    @NotBlank
    private String nombreTarea;

    private String estado;

    private boolean completa;

    @NotBlank
    private String descripcionTarea;

    @NotBlank
    private String historiaUsuarioId;

    public TareaDTO() {
    }

    public TareaDTO(String tareaId,String desarrolladorId, String nombreTarea, String estado, boolean completa, String descripcionTarea, String historiaUsuarioId) {
        this.tareaId = tareaId;
        this.desarrolladorId=desarrolladorId;
        this.nombreTarea = nombreTarea;
        this.estado = estado;
        this.completa=completa;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
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

