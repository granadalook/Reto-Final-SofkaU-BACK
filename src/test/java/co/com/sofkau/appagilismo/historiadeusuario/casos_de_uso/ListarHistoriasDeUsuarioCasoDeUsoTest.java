package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ListarHistoriasDeUsuarioCasoDeUsoTest {

    @Autowired
    private HistoriaDeUsuarioRepositorio repositorio;

    @Autowired
    private ListarHistoriasDeUsuarioCasoDeUso casoDeUso;

    @Autowired
    private MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    @BeforeEach
    public void configuracionInicial(){
        repositorio = mock(HistoriaDeUsuarioRepositorio.class);
        casoDeUso = new ListarHistoriasDeUsuarioCasoDeUso(mapperHistoriaDeUsuario, repositorio);
    }

    @Test
    void listarTodasLasHistoriasDeUsuarioTest() {
      /*  var historiaDeUsuario1 = new HistoriaDeUsuario();
        historiaDeUsuario1.setUsuarioId("002");
        historiaDeUsuario1.setHistoriaUsuarioId("001");
        historiaDeUsuario1.setDescripcion("Descripcion de historia de usuario 1.");
        historiaDeUsuario1.setProyectoId("0010");

        when(repositorio.findAll()).thenReturn(Flux.just(historiaDeUsuario1));

        StepVerifier.create(casoDeUso.get())
                .expectNextMatches(historias -> {
                    assert historias.getHistoriaUsuarioId().equalsIgnoreCase("001");
                    assert historias.getUsuarioId().equalsIgnoreCase(historiaDeUsuario1.getUsuarioId());
                    assert historias.getDescripcion().equalsIgnoreCase(historiaDeUsuario1.getDescripcion());
                    assert historias.getProyectoId().equalsIgnoreCase("0010");
                    return true;
                })
                .verifyComplete();

        verify(repositorio).findAll();*/
    }
}