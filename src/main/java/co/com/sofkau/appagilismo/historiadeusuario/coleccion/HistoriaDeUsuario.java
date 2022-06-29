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

    private String descripcion;

    @NotBlank
    private String estimacion;

    @NotBlank
    private boolean estado;

    @NotBlank
    private Integer porcentajeDeAvance;

    @NotBlank
    private String liderTecnicoId;

    @NotBlank
    private String desarrolladorId;

    @NotBlank
    private String proyectoId;

    public HistoriaDeUsuario() {
    }

    public HistoriaDeUsuario(String historiaUsuarioId,String tituloHistoriaUsuario, String descripcion, String estimacion, boolean estado, Integer porcentajeDeAvance, String liderTecnicoId, String desarrolladorId,String proyectoId) {
        this.historiaUsuarioId = historiaUsuarioId;
        this.tituloHistoriaUsuario=tituloHistoriaUsuario;
        this.descripcion = descripcion;
        this.estimacion=estimacion;
        this.estado=estado;
        this.porcentajeDeAvance=porcentajeDeAvance;
        this.liderTecnicoId=liderTecnicoId;
        this.desarrolladorId = desarrolladorId;
        this.proyectoId=proyectoId;
    }

    public HistoriaDeUsuario(String tituloHistoriaUsuario,String estimacion, boolean estado, Integer porcentajeDeAvance,String liderTecnicoId, String desarrolladorId, String proyectoId) {
        this.tituloHistoriaUsuario=tituloHistoriaUsuario;
        this.estimacion = estimacion;
        this.estado=estado;
        this.porcentajeDeAvance=porcentajeDeAvance;
        this.liderTecnicoId = liderTecnicoId;
        this.desarrolladorId = desarrolladorId;
        this.proyectoId=proyectoId;
    }

    public String getHistoriaUsuarioId() {
        return historiaUsuarioId;
    }

    public void setHistoriaUsuarioId(String historiaUsuarioId) {
        this.historiaUsuarioId = historiaUsuarioId;
    }

    public String getTituloHistoriaUsuario() {
        return tituloHistoriaUsuario;
    }

    public void setTituloHistoriaUsuario(String tituloHistoriaUsuario) {
        this.tituloHistoriaUsuario = tituloHistoriaUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstimacion() {
        return estimacion;
    }

    public void setEstimacion(String estimacion) {
        this.estimacion = estimacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getPorcentajeDeAvance() {
        return porcentajeDeAvance;
    }

    public void setPorcentajeDeAvance(Integer porcentajeDeAvance) {
        this.porcentajeDeAvance = porcentajeDeAvance;
    }

    public String getLiderTecnicoId() {
        return liderTecnicoId;
    }

    public void setLiderTecnicoId(String liderTecnicoId) {
        this.liderTecnicoId = liderTecnicoId;
    }

    public String getDesarrolladorId() {
        return desarrolladorId;
    }

    public void setDesarrolladorId(String desarrolladorId) {
        this.desarrolladorId = desarrolladorId;
    }

    public String getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(String proyectoId) {
        this.proyectoId = proyectoId;
    }
}
