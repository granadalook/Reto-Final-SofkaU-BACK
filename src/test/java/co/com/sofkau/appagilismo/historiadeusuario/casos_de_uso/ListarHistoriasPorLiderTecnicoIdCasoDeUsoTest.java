package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;
import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class ListarHistoriasPorLiderTecnicoIdCasoDeUsoTest {
    @Autowired
    HistoriaDeUsuarioRepositorio historiaDeUsuarioRepositorio;
    @Autowired
    MapperHistoriaDeUsuario mapperHistoriaDeUsuario;
    @Autowired
    ListarHistoriasPorLiderTecnicoIdCasoDeUso listarHistoriasPorLiderTecnicoIdCasoDeUso;

    static final String historiaUsuarioId = "00001";
    private static final String tituloHistoriaUsuario = "HistoriaDeUsuarioTest";
    private static final String estimacion = "8";
    private static final String estado = "TODO";
    private static final Integer porcentajeDeAvance = 10;
    private static final String liderTecnicoId = "Manuel Salas";
    private static final String desarrolladorId = "Edgar M";
    private static final String proyectoId = "Agilismo";
    private static final String descripcionTarea = "Realizar prueba a 'CrearTareaUsoDeCaso'.";

    @BeforeEach
    public void configuracionInicial() {
        historiaDeUsuarioRepositorio = mock(HistoriaDeUsuarioRepositorio.class);
        listarHistoriasPorLiderTecnicoIdCasoDeUso = new ListarHistoriasPorLiderTecnicoIdCasoDeUso(historiaDeUsuarioRepositorio,mapperHistoriaDeUsuario);
    }

    @Test
    void listarTodasLasHistoriasPorLiderTecnicoTest(){
        var historiaDeUsuario = new HistoriaDeUsuario();
        historiaDeUsuario.setHistoriaUsuarioId(historiaUsuarioId);
        historiaDeUsuario.setTituloHistoriaUsuario(tituloHistoriaUsuario);
        historiaDeUsuario.setEstimacion(estimacion);
        historiaDeUsuario.setEstado(estado);
        historiaDeUsuario.setPorcentajeDeAvance(porcentajeDeAvance);
        historiaDeUsuario.setLiderTecnicoId(liderTecnicoId);
        historiaDeUsuario.setDesarrolladorId(desarrolladorId);
        historiaDeUsuario.setProyectoId(proyectoId);

        var historiaDeUsuarioDTO = new HistoriaDeUsuarioDTO();
        historiaDeUsuarioDTO.setHistoriaUsuarioId(historiaUsuarioId);
        historiaDeUsuarioDTO.setTituloHistoriaUsuario(tituloHistoriaUsuario);
        historiaDeUsuarioDTO.setEstimacion(estimacion);
        historiaDeUsuarioDTO.setEstado(estado);
        historiaDeUsuarioDTO.setPorcentajeDeAvance(porcentajeDeAvance);
        historiaDeUsuarioDTO.setLiderTecnicoId(liderTecnicoId);
        historiaDeUsuarioDTO.setDesarrolladorId(desarrolladorId);
        historiaDeUsuarioDTO.setProyectoId(proyectoId);

        Assertions.assertEquals(historiaDeUsuarioDTO.getEstado(),historiaDeUsuario.getEstado());
        Assertions.assertNotNull(historiaDeUsuarioDTO);
        Assertions.assertNotNull(historiaDeUsuario);
    }

}
