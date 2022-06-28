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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
        var historiaDeUsuario1 = new HistoriaDeUsuario();
        historiaDeUsuario1.setUsuarioId("002");
        historiaDeUsuario1.setHistoriaUsuarioId("001");
        historiaDeUsuario1.setDescripcion("Descripcion de historia de usuario 1.");
        historiaDeUsuario1.setProyectoId("0010");

        var historiaDeUsuario2 = new HistoriaDeUsuario();
        historiaDeUsuario2.setUsuarioId("002");
        historiaDeUsuario2.setHistoriaUsuarioId("002");
        historiaDeUsuario2.setDescripcion("Descripcion de historia de usuario 2.");
        historiaDeUsuario2.setProyectoId("0010");

        //Flux.just(historiaDeUsuario1, historiaDeUsuario2);

        var historiaDeUsuario1DTO = new HistoriaDeUsuarioDTO();
        historiaDeUsuario1DTO.setUsuarioId("002");
        historiaDeUsuario1DTO.setHistoriaUsuarioId("001");
        historiaDeUsuario1DTO.setDescripcion("Descripcion de historia de usuario 1.");
        historiaDeUsuario1DTO.setProyectoId("0010");

        var historiaDeUsuario2DTO = new HistoriaDeUsuarioDTO();
        historiaDeUsuario2DTO.setUsuarioId("002");
        historiaDeUsuario2DTO.setHistoriaUsuarioId("002");
        historiaDeUsuario2DTO.setDescripcion("Descripcion de historia de usuario 2.");
        historiaDeUsuario2DTO.setProyectoId("0010");

        //Flux.just()
    }
}