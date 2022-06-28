package co.com.sofkau.appagilismo.tarea.colleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Document(collection = "tareas")
public class Tarea {
    @Id
    private String tareaId;

    @NotBlank
    private String desarrolladorId;

    @NotBlank
    private String nombreTarea;

    @NotBlank
    private boolean estadoTarea;

    @NotBlank
    private String descripcionTarea;


    public Tarea(){

    };

    public Tarea(String tareaId, String desarrolladorId, String nombreTarea, boolean estadoTarea, String descripcionTarea) {
        this.tareaId = tareaId;
        this.desarrolladorId = desarrolladorId;
        this.nombreTarea = nombreTarea;
        this.estadoTarea = estadoTarea;
        this.descripcionTarea = descripcionTarea;
    }

    public Tarea(String desarrolladorId, String nombreTarea, boolean estadoTarea, String descripcionTarea) {
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
}
