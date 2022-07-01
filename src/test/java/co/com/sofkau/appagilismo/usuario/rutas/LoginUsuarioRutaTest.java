package co.com.sofkau.appagilismo.usuario.rutas;

import co.com.sofkau.appagilismo.usuario.casos_de_uso.LogInCasoDeUso;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioLogin;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.verify;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {LoginUsuarioRuta.class, LogInCasoDeUso.class})
class LoginUsuarioRutaTest {

    @MockBean
    private UsuarioRepositorio repositorio;

    @Autowired
    private WebTestClient webTestClient;

    private static final String ID = "U-0001";
    private static final String NOMBRECOMPLETO = "Andres Felipe Lozada";
    private static final String EMAIL = "ciendecilantro.agile@gmail.com";
    private static final String PASSWORD = "123456789";
    private static final String ROL = "Desarrollador";

    @Test
    void loginRutaTest(){

        var usuario = new UsuarioLogin();
        usuario.setEmail(EMAIL);
        usuario.setPassword(PASSWORD);

        var usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsuarioId(ID);
        usuarioDTO.setNombreCompleto(NOMBRECOMPLETO);
        usuarioDTO.setEmail(EMAIL);
        usuarioDTO.setPassword(PASSWORD);
        usuarioDTO.setRol(ROL);

        Mockito.when(repositorio.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword())).thenReturn(Mono.just(usuarioDTO));

        webTestClient.post()
                .uri("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(usuarioDTO), UsuarioDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(UsuarioDTO.class)
                .value(respuesta -> {
                    Assertions.assertEquals(respuesta.getUsuarioId(), usuarioDTO.getUsuarioId());
                    Assertions.assertEquals(respuesta.getNombreCompleto(), usuarioDTO.getNombreCompleto());
                    Assertions.assertEquals(respuesta.getEmail(), usuarioDTO.getEmail());
                    Assertions.assertEquals(respuesta.getPassword(), usuarioDTO.getPassword());
                    Assertions.assertEquals(respuesta.getRol(), usuarioDTO.getRol());
                });
        verify(repositorio).findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
    }
}