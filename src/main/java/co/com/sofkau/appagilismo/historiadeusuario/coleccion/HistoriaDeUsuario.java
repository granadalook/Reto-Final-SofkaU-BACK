package co.com.sofkau.appagilismo.historiadeusuario.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "historiadeusuario")
public class HistoriaDeUsuario {
    @Id
    private String historiaUsuarioId;

    @NotBlank
    private String tituloHistoriaUsuario;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String liderTecnicoId;

    @NotBlank
    private String desarrolladorId;

    @NotBlank
    private String proyectoId;

    public HistoriaDeUsuario() {
    }

    public HistoriaDeUsuario(String historiaUsuarioId,String tituloHistoriaUsuario, String descripcion, String liderTecnicoId, String desarrolladorId,String proyectoId) {
        this.historiaUsuarioId = historiaUsuarioId;
        this.tituloHistoriaUsuario=tituloHistoriaUsuario;
        this.descripcion = descripcion;
        this.liderTecnicoId=liderTecnicoId;
        this.desarrolladorId = desarrolladorId;
        this.proyectoId=proyectoId;
    }

    public HistoriaDeUsuario(String tituloHistoriaUsuario,String descripcion,String liderTecnicoId, String desarrolladorId, String proyectoId) {
        this.tituloHistoriaUsuario=tituloHistoriaUsuario;
        this.descripcion = descripcion;
        this.liderTecnicoId = liderTecnicoId;
        this.desarrolladorId = desarrolladorId;
        this.proyectoId=proyectoId;
    }

    public String getTituloHistoriaUsuario() {
        return tituloHistoriaUsuario;
    }

    public void setTituloHistoriaUsuario(String tituloHistoriaUsuario) {
        this.tituloHistoriaUsuario = tituloHistoriaUsuario;
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

    public String getLiderTecnicoId() {
        return liderTecnicoId;
    }

    public void setLiderTecnicoId(String liderTecnicoId) {
        this.liderTecnicoId = liderTecnicoId;
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

    public String getDesarrolladorId() {
        return desarrolladorId;
    }

    public void setDesarrolladorId(String desarrolladorId) {
        this.desarrolladorId = desarrolladorId;
    }
}
