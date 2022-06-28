package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CrearHistoriaDeUsuarioCasoDeUsoTest {

    @Autowired
    private HistoriaDeUsuarioRepositorio repositorio;

    @Autowired
    private CrearHistoriaDeUsuarioCasoDeUso casoDeUso;

    @Autowired
    private MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    private static final String ID = "H-0001";

    private static final String DESCRIPCION = "Descripcion de la nueva Historia de Usuario.";

    private static final String USUARIOID = "002";

    private static final String PROYECTOID = "00001";

    @BeforeEach
    public void configuracionInicial(){
        repositorio = mock(HistoriaDeUsuarioRepositorio.class);
        casoDeUso = new CrearHistoriaDeUsuarioCasoDeUso(repositorio, mapperHistoriaDeUsuario);
    }

    @Test
    void crearHistoriaDeUsuarioTest(){
        var historiaDeUsuario = new HistoriaDeUsuario();
        historiaDeUsuario.setUsuarioId(USUARIOID);
        historiaDeUsuario.setHistoriaUsuarioId(ID);
        historiaDeUsuario.setDescripcion(DESCRIPCION);
        historiaDeUsuario.setProyectoId(PROYECTOID);

        var historiaDeUsuarioDTO = new HistoriaDeUsuarioDTO();
        historiaDeUsuarioDTO.setUsuarioId(USUARIOID);
        historiaDeUsuarioDTO.setHistoriaUsuarioId(ID);
        historiaDeUsuarioDTO.setDescripcion(DESCRIPCION);
        historiaDeUsuarioDTO.setProyectoId(PROYECTOID);

        when(repositorio.save(Mockito.any(HistoriaDeUsuario.class))).thenReturn(Mono.just(historiaDeUsuario));

        StepVerifier.create(casoDeUso.crearHistoriaDeUsuario(historiaDeUsuarioDTO))
                .expectNextMatches(historia -> {
                    assert historia.getHistoriaUsuarioId().equalsIgnoreCase(historiaDeUsuario.getHistoriaUsuarioId());
                    assert historia.getUsuarioId().equalsIgnoreCase(historiaDeUsuario.getUsuarioId());
                    assert historia.getDescripcion().equalsIgnoreCase(historiaDeUsuario.getDescripcion());
                    assert historia.getProyectoId().equalsIgnoreCase(historiaDeUsuario.getProyectoId());
                    return true;
                })
                .verifyComplete();

        verify(repositorio).save(Mockito.any(HistoriaDeUsuario.class));
    }
}