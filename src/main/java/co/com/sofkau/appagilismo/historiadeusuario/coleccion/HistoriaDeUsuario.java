package co.com.sofkau.appagilismo.historiadeusuario.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "historiadeusuario")
public class HistoriaDeUsuario {
    @Id
    private String historiaUsuarioId;

    @NotBlank
    private String Descripcion;

    @NotBlank
    private String usuarioId;

    public HistoriaDeUsuario() {
    }

    public HistoriaDeUsuario(String historiaUsuarioId, String descripcion, String usuarioId) {
        this.historiaUsuarioId = historiaUsuarioId;
        Descripcion = descripcion;
        this.usuarioId = usuarioId;
    }

    public HistoriaDeUsuario(String descripcion, String usuarioId) {
        Descripcion = descripcion;
        this.usuarioId = usuarioId;
    }

    public String getHistoriaUsuarioId() {
        return historiaUsuarioId;
    }

    public void setHistoriaUsuarioId(String historiaUsuarioId) {
        this.historiaUsuarioId = historiaUsuarioId;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}
