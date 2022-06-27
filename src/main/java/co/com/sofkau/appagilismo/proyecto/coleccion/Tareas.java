package co.com.sofkau.appagilismo.proyecto.coleccion;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Document (collection = "tareas")
public class Tareas {

    @Id
    private String tareasiId;

    @NotBlank
    private String nombreTarea;

    @NotBlank
    private boolean estadoTarea;

    private String descripcionTarea;

    private List<String> miembros;

    public Tareas(){

    }

    public Tareas(String tareasiId, String nombreTarea, boolean estadoTarea, String descripcionTarea, List<String> miembros) {
        this.tareasiId = tareasiId;
        this.nombreTarea = nombreTarea;
        this.estadoTarea = estadoTarea;
        this.descripcionTarea = descripcionTarea;
        this.miembros = miembros;
    }

    public Tareas(String tareasiId, String nombreTarea, boolean estadoTarea) {
        this.tareasiId = tareasiId;
        this.nombreTarea = nombreTarea;
        this.estadoTarea = estadoTarea;
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
}
