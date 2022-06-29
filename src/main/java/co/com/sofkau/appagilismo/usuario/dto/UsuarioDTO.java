package co.com.sofkau.appagilismo.usuario.dto;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;

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

    private List<String> idProyectosAsociados;

    private List<ProyectoDTO> proyectosAsociados;

    private List<HistoriaDeUsuarioDTO> historiasDeUsuario;

    public UsuarioDTO() {}

    public UsuarioDTO(String usuarioId, String nombreCompleto, String email, String password, String rol, List<String> idProyectosAsociados) {
        this.usuarioId=usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.rol=rol;
        this.idProyectosAsociados = Optional.ofNullable(idProyectosAsociados).orElse(new ArrayList<>());
    }

    public UsuarioDTO(String nombreCompleto, String email, String password, String rol, List<String> idProyectosAsociados) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.rol=rol;
        this.idProyectosAsociados = Optional.ofNullable(idProyectosAsociados).orElse(new ArrayList<>());
    }

    public UsuarioDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public List<ProyectoDTO> getProyectosAsociados() {
        this.proyectosAsociados = Optional.ofNullable(proyectosAsociados).orElse(new ArrayList<>());
        return proyectosAsociados;
    }

    public List<String> getIdProyectosAsociados() {
        this.idProyectosAsociados = Optional.ofNullable(idProyectosAsociados).orElse(new ArrayList<>());
        return idProyectosAsociados;
    }

    public void setIdProyectosAsociados(List<String> idProyectosAsociados) {
        this.idProyectosAsociados = idProyectosAsociados;
    }

    public void setProyectosAsociados(List<ProyectoDTO> proyectosAsociados) {
        this.proyectosAsociados = proyectosAsociados;
    }

    public List<HistoriaDeUsuarioDTO> getHistoriasDeUsuario() {
        this.historiasDeUsuario = Optional.ofNullable(historiasDeUsuario).orElse(new ArrayList<>());
        return historiasDeUsuario;
    }

    public void setHistoriasDeUsuario(List<HistoriaDeUsuarioDTO> historiasDeUsuario) {
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

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "usuarioId='" + usuarioId + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
