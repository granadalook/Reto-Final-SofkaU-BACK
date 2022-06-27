package co.com.sofkau.appagilismo.usuario.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String usuarioId;

    @NotBlank
    private String nombreCompleto;

    @Indexed(unique = true)
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String rol;


    public Usuario() {
    }

    public Usuario(String nombreCompleto, String email, String password, String rol) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.rol=rol;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
