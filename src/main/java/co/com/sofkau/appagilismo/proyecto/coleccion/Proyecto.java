package co.com.sofkau.appagilismo.proyecto.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

/**
 * Proyecto class.
 * Clase que representa a la colección Proyecto creada en la base de datos.
 * @author 100 de cilantro
 */
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

    private Integer porcentajeDeAvance;

    private Boolean estado;

    public Proyecto() {}

    public Proyecto(String proyectoId, String nombre, String arquitectoId, Integer porcentajeDeAvance, Boolean estado, String liderTecnicoId) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
        this.arquitectoId = arquitectoId;
        this.porcentajeDeAvance = porcentajeDeAvance;
        this.estado = estado;
        this.liderTecnicoId = liderTecnicoId;
    }

    public Proyecto(String nombre, String arquitectoId, String liderTecnicoId, Integer porcentajeDeAvance, Boolean estado) {
        this.nombre = nombre;
        this.arquitectoId = arquitectoId;
        this.porcentajeDeAvance = porcentajeDeAvance;
        this.estado = estado;
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

    public Integer getPorcentajeDeAvance() {
        return porcentajeDeAvance;
    }

    public void setPorcentajeDeAvance(Integer porcentajeDeAvance) {
        if (porcentajeDeAvance == null){
            this.porcentajeDeAvance = 0;
        }else {
            this.porcentajeDeAvance = porcentajeDeAvance;
        }
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        if (estado == null){
            this.estado = false;
        }else {
            this.estado = estado;
        }
    }
}
