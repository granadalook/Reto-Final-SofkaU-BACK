package co.com.sofkau.appagilismo.usuario.casos_de_uso;

import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioLogin;
import co.com.sofkau.appagilismo.usuario.repositorio.UsuarioRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class LogInCasoDeUsoTest {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Autowired
    private LogInCasoDeUso casoDeUso;

    private static final String ID = "U-0001";
    private static final String NOMBRECOMPLETO = "Andres Felipe Lozada";
    private static final String EMAIL = "ciendecilantro.agile@gmail.com";
    private static final String PASSWORD = "123456789";
    private static final String ROL = "Desarrollador";

    @BeforeEach
    public void configuracionInicial(){
        repositorio = mock(UsuarioRepositorio.class);
        casoDeUso = new LogInCasoDeUso(repositorio);
    }

    @Test
    void loginUsuarioTest(){

        var usuario = new UsuarioLogin();
        usuario.setEmail(EMAIL);
        usuario.setPassword(PASSWORD);

        var usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsuarioId(ID);
        usuarioDTO.setNombreCompleto(NOMBRECOMPLETO);
        usuarioDTO.setEmail(EMAIL);
        usuarioDTO.setPassword(PASSWORD);
        usuarioDTO.setRol(ROL);

        when(repositorio.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword())).thenReturn(Mono.just(usuarioDTO));

        StepVerifier.create(casoDeUso.logIn(usuario))
                .expectNextMatches(user ->{
                    assert user.getUsuarioId().equalsIgnoreCase(usuarioDTO.getUsuarioId());
                    assert user.getNombreCompleto().equalsIgnoreCase(usuarioDTO.getNombreCompleto());
                    assert user.getEmail().equalsIgnoreCase(usuarioDTO.getEmail());
                    assert user.getPassword().equalsIgnoreCase(usuarioDTO.getPassword());
                    assert user.getRol().equalsIgnoreCase(usuarioDTO.getRol());
                    return true;
                })
                .verifyComplete();

        verify(repositorio).findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
    }
}