package co.com.sofkau.appagilismo.usuario.dto;

import org.springframework.data.mongodb.core.index.Indexed;

public class UsuarioDTO {


    private String usuarioId;


    private String nombreCompleto;


    private String email;


    private String password;


    private Set<String> proyectosAsociados;

    public UsuarioDTO(String nombreCompleto, String email, String password) {
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

    public Set<String> getProyectosAsociados() {
        return proyectosAsociados;
    }

    public void setProyectosAsociados(Set<String> proyectosAsociados) {
        this.proyectosAsociados = proyectosAsociados;
    }
}
