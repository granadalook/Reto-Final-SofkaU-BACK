package co.com.sofkau.appagilismo.usuario.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDTO {

    private String usuarioId;

    @NotBlank
    private String nombreCompleto;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String rol;

    private List<String> proyectosAsociados;

    private List<String> historiasDeUsuario;

    public UsuarioDTO() {}

    public UsuarioDTO(String usuarioId, String nombreCompleto, String email, String password, String rol) {
        this.usuarioId=usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.rol=rol;
    }

    public UsuarioDTO(String nombreCompleto, String email, String password) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.rol=rol;
    }

    public List<String> getProyectosAsociados() {
        this.proyectosAsociados = Optional.ofNullable(proyectosAsociados).orElse(new ArrayList<>());
        return proyectosAsociados;
    }

    public void setProyectosAsociados(List<String> proyectosAsociados) {
        this.proyectosAsociados = proyectosAsociados;
    }

    public List<String> getHistoriasDeUsuario() {
        this.historiasDeUsuario = Optional.ofNullable(historiasDeUsuario).orElse(new ArrayList<>());
        return historiasDeUsuario;
    }

    public void setHistoriasDeUsuario(List<String> historiasDeUsuario) {
        this.historiasDeUsuario = historiasDeUsuario;
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
