package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.AsociarHistoriaDeUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EditarTareaCasoDeUsoTest {
    @Autowired
    TareaRepositorio tareaRepositorio;
    @Autowired
    MapperTarea mapperTarea;
    @Autowired
    MapperHistoriaDeUsuario mapperHistoriaDeUsuario;
    @Autowired
    AsociarHistoriaDeUsuarioCasoDeUso asociarHistoriaDeUsuarioCasoDeUso;
    @Autowired
    EditarTareaCasoDeUso editarTareaCasoDeUso;

    private static final String tareaId = "0001";
    private static final String desarrolladorId = "1000445418";
    private static final String nombreTarea = "Test";
    private static final String estado = "TODO";
    private static final boolean completa = false;
    private static final String descripcionTarea = "Realizar prueba a 'CrearTareaUsoDeCaso'.";
    private static final String historiaUsuarioId = "0001";

    @BeforeEach
    public void ConfiguracionMock (){
        tareaRepositorio = mock(TareaRepositorio.class);
        editarTareaCasoDeUso = new EditarTareaCasoDeUso(tareaRepositorio,mapperTarea,mapperHistoriaDeUsuario,asociarHistoriaDeUsuarioCasoDeUso);
    }
    @Test
    void editarTareaTest(){
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

        when(tareaRepositorio.save(Mockito.any(Tarea.class))).thenReturn(Mono.just(tarea));
        Assertions.assertEquals(tareaDTO.getHistoriaUsuarioId(),tarea.getHistoriaUsuarioId());

    }

}
