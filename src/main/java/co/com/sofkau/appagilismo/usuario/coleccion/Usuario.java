package co.com.sofkau.appagilismo.usuario.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    private List<String> idProyectosAsociados;


    public Usuario() {
    }

    public Usuario(String nombreCompleto, String email, String password, String rol, List<String> idProyectosAsociados) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.rol=rol;
        this.idProyectosAsociados = Optional.ofNullable(idProyectosAsociados).orElse(new ArrayList<>());
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

    public List<String> getIdProyectosAsociados() {
        this.idProyectosAsociados = Optional.ofNullable(idProyectosAsociados).orElse(new ArrayList<>());
        return idProyectosAsociados;
    }

    public void setIdProyectosAsociados(List<String> idProyectosAsociados) {
        this.idProyectosAsociados = idProyectosAsociados;
    }
}
