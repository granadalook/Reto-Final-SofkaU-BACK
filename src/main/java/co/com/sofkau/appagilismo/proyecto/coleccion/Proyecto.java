package co.com.sofkau.appagilismo.proyecto.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Document(collection = "proyecto")
public class Proyecto {

    @Id
    private String proyectoId;

    @NotBlank
    private String nombre;

    @NotBlank
    private String arquitectoId;

    @NotBlank
    private String liderTecnicoId;

    private List<String> desarrolladorId;

    public Proyecto() {
    }

    public Proyecto(String proyectoId, String nombre, String arquitectoId, String liderTecnicoId, List<String> desarrolladorId) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
        this.arquitectoId = arquitectoId;
        this.liderTecnicoId = liderTecnicoId;
        this.desarrolladorId = desarrolladorId;
    }

    public Proyecto(String nombre, String arquitectoId, String liderTecnicoId, List<String> desarrolladorId) {
        this.nombre = nombre;
        this.arquitectoId = arquitectoId;
        this.liderTecnicoId = liderTecnicoId;
        this.desarrolladorId = desarrolladorId;
    }

    public Proyecto(String nombre, String arquitectoId, String liderTecnicoId) {
        this.nombre = nombre;
        this.arquitectoId = arquitectoId;
        this.liderTecnicoId = liderTecnicoId;
    }

    public String getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(String proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArquitectoId() {
        return arquitectoId;
    }

    public void setArquitectoId(String arquitectoId) {
        this.arquitectoId = arquitectoId;
    }

    public String getLiderTecnicoId() {
        return liderTecnicoId;
    }

    public void setLiderTecnicoId(String liderTecnicoId) {
        this.liderTecnicoId = liderTecnicoId;
    }

    public List<String> getDesarrolladorId() {
        return desarrolladorId;
    }

    public void setDesarrolladorId(List<String> desarrolladorId) {
        this.desarrolladorId.add(String.valueOf(desarrolladorId));
    }
}
