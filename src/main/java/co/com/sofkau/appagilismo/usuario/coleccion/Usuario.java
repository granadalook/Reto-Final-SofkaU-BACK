package co.com.sofkau.appagilismo.usuario.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String usuarioId;

    @NotNull
    private String nombreCompleto;

    @Indexed(unique = true)
    private String email;

    @NotNull
    private String password;


    public Usuario() {
    }

    public Usuario(String nombreCompleto, String email, String password) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
