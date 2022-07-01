package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.mapper.MapperUsuario;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import co.com.sofkau.appagilismo.usuario.utilidades.EnviarMail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CrearUsuarioCasoDeUsoTest {

    @Autowired
    private UsuarioRepositorio repositorio;
    @MockBean
    private EnviarMail enviarMail;
    @Autowired
    private CrearUsuarioCasoDeUso casoDeUso;
    @Autowired
    private MapperUsuario mapperUsuario;
    private static final String ID = "U-0001";
    private static final String NOMBRECOMPLETO = "Andres Felipe Lozada";
    private static final String EMAIL = "ciendecilantro.agile@gmail.com";
    private static final String PASSWORD = "123456789";
    private static final String ROL = "Desarrollador";

    @BeforeEach
    public void configuracionInicial() {
        repositorio = mock(UsuarioRepositorio.class);
        casoDeUso = new CrearUsuarioCasoDeUso(repositorio, mapperUsuario);
        enviarMail = mock(EnviarMail.class);
    }

    @Test
    void crearUsuarioTest() {

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

        when(repositorio.save(Mockito.any(Usuario.class))).thenReturn(Mono.just(usuario));

        Assertions.assertNotNull(usuario);
        Assertions.assertNotNull(usuarioDTO);


        //verify(repositorio).save(Mockito.any(Usuario.class));
    }
}