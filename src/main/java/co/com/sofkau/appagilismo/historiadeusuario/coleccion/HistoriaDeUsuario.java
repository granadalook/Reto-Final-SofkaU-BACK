package co.com.sofkau.appagilismo.historiadeusuario.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "historiadeusuario")
public class HistoriaDeUsuario {
    @Id
    private String historiaUsuarioId;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String usuarioId;

    @NotBlank
    private String proyectoId;

    public HistoriaDeUsuario() {
    }

    public HistoriaDeUsuario(String historiaUsuarioId, String descripcion, String usuarioId,String proyectoId) {
        this.historiaUsuarioId = historiaUsuarioId;
        this.descripcion = descripcion;
        this.usuarioId = usuarioId;
        this.proyectoId=proyectoId;
    }

    public HistoriaDeUsuario(String descripcion, String usuarioId, String proyectoId) {
        this.descripcion = descripcion;
        this.usuarioId = usuarioId;
        this.proyectoId=proyectoId;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(String proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}
