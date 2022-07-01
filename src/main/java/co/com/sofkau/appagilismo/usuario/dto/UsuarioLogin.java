package co.com.sofkau.appagilismo.usuario.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioLogin {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    public UsuarioLogin() {
    }

    public UsuarioLogin(String email, String password) {
        this.email = email;
        this.password = password;
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
