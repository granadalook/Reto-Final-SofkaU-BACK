package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.junit.jupiter.api.Assertions;
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
    HistoriaDeUsuarioRepositorio historiaDeUsuarioRepositorio;
    @Autowired
    MapperHistoriaDeUsuario mapperHistoriaDeUsuario;
    @Autowired
    TareaRepositorio tareaRepositorio;
    @Autowired
    MapperTarea mapperTarea;
    @Autowired
    ListarHistoriasDeUsuarioCasoDeUso listarHistoriasDeUsuarioCasoDeUso;

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
    public void configuracionInicial(){
       tareaRepositorio = mock(TareaRepositorio.class);
       listarHistoriasDeUsuarioCasoDeUso = new ListarHistoriasDeUsuarioCasoDeUso(mapperHistoriaDeUsuario, historiaDeUsuarioRepositorio,tareaRepositorio,mapperTarea);
       historiaDeUsuarioRepositorio = mock(HistoriaDeUsuarioRepositorio.class);
    }

    @Test
    void listarTodasLasHistoriasDeUsuarioTest() {
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

        var tarea = new Tarea();
        tarea.setDesarrolladorId(desarrolladorId);
        tarea.setEstado(estado);
        tarea.setDescripcionTarea(descripcionTarea);
        tarea.setHistoriaUsuarioId(historiaUsuarioId);

        var tareaDTO = new TareaDTO();
        tareaDTO.setDesarrolladorId(desarrolladorId);
        tareaDTO.setEstado(estado);
        tareaDTO.setDescripcionTarea(descripcionTarea);
        tareaDTO.setHistoriaUsuarioId(historiaUsuarioId);

        Assertions.assertEquals(tareaDTO.getEstado(),tarea.getEstado());
        Assertions.assertNotNull(tareaDTO);
        Assertions.assertNotNull(tarea);

    }
}