package co.com.sofkau.appagilismo.usuario.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class UsuarioDTO {


    private String usuarioId;

    @NotBlank
    private String nombreCompleto;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String rol;

    private Set<String> proyectosAsociados;

    private Set<String> historiasDeUsuario;



    public UsuarioDTO(String usuarioId,String nombreCompleto, String email, String password, String rol) {
        this.usuarioId=usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.rol=rol;
    }

    public UsuarioDTO(String nombreCompleto, String email, String password, String rol) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.rol= rol;
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

    public Set<String> getProyectosAsociados() {
        return proyectosAsociados;
    }

    public void setProyectosAsociados(Set<String> proyectosAsociados) {
        this.proyectosAsociados = proyectosAsociados;
    }

    public Set<String> getHistoriasDeUsuario() {
        return historiasDeUsuario;
    }

    public void setHistoriasDeUsuario(Set<String> historiasDeUsuario) {
        this.historiasDeUsuario = historiasDeUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
