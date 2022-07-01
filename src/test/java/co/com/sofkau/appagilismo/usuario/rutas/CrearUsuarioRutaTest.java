package co.com.sofkau.appagilismo.usuario.rutas;

import co.com.sofkau.appagilismo.usuario.casos_de_uso.CrearUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.mapper.MapperUsuario;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import co.com.sofkau.appagilismo.utilidades.EnviarMail;
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
@ContextConfiguration(classes = {CrearUsuarioRuta.class, CrearUsuarioCasoDeUso.class, MapperUsuario.class})
class CrearUsuarioRutaTest {

    @MockBean
    private UsuarioRepositorio repositorio;

    @MockBean
    private EnviarMail enviarMail;

    @Autowired
    private WebTestClient webTestClient;

    private static final String ID = "U-0001";
    private static final String NOMBRECOMPLETO = "Andres Felipe Lozada";
    private static final String EMAIL = "ciendecilantro.agile@gmail.com";
    private static final String PASSWORD = "123456789";
    private static final String ROL = "Desarrollador";

    @Test
    void usuarioRutasTest() {

        var usuario = new Usuario();
        usuario.setUsuarioId(ID);
        usuario.setNombreCompleto(NOMBRECOMPLETO);
        usuario.setEmail(EMAIL);
        usuario.setPassword(PASSWORD);
        usuario.setRol(ROL);

        var usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsuarioId(ID);
        usuarioDTO.setNombreCompleto(NOMBRECOMPLETO);
        usuarioDTO.setEmail(EMAIL);
        usuarioDTO.setPassword(PASSWORD);
        usuarioDTO.setRol(ROL);

        Mockito.when(repositorio.save(Mockito.any(Usuario.class))).thenReturn(Mono.just(usuario));

        webTestClient.post()
                .uri("/usuario/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(usuarioDTO), UsuarioDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(UsuarioDTO.class)
                .value(respuesta -> {
                    Assertions.assertEquals(respuesta.getUsuarioId(), usuario.getUsuarioId());
                    Assertions.assertEquals(respuesta.getNombreCompleto(), usuario.getNombreCompleto());
                    Assertions.assertEquals(respuesta.getEmail(), usuario.getEmail());
                    Assertions.assertEquals(respuesta.getPassword(), usuario.getPassword());
                    Assertions.assertEquals(respuesta.getRol(), usuario.getRol());
                });
        verify(repositorio).save(Mockito.any(Usuario.class));
    }
}