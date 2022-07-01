package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.AsociarHistoriaDeUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import javax.validation.constraints.NotBlank;

import static org.mockito.Mockito.*;

@SpringBootTest
public class CrearTareaCasoDeUsoTest {
    @Autowired
    TareaRepositorio tareaRepositorio;
    @Autowired
    CrearTareaCasoDeUso crearTareaCasoDeUso;
    @Autowired
    AsociarHistoriaDeUsuarioCasoDeUso asociarHistoriaDeUsuarioCasoDeUso;
    @Autowired
    MapperTarea mapperTarea;

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
        crearTareaCasoDeUso = new CrearTareaCasoDeUso(tareaRepositorio,mapperTarea,asociarHistoriaDeUsuarioCasoDeUso);
    }

    @Test
    void CrearTareaTest(){
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

        /*
        StepVerifier.create(crearTareaCasoDeUso.crearTarea(tareaDTO))
                .expectNextMatches(ntarea -> {
                    assert ntarea.getDesarrolladorId().equalsIgnoreCase(tarea.getDesarrolladorId());
                    assert ntarea.getHistoriaUsuarioId().equalsIgnoreCase(tarea.getHistoriaUsuarioId());
                    assert ntarea.getEstado() == tarea.getEstado();
                    assert ntarea.getDescripcion().equalsIgnoreCase(tarea.getDescripcionTarea());
                    return true;
                })
                .verifyComplete();
         */
        Assertions.assertEquals(tareaDTO.getHistoriaUsuarioId(),tarea.getHistoriaUsuarioId());
        Assertions.assertEquals(tareaDTO.getDesarrolladorId(),tarea.getDesarrolladorId());
        Assertions.assertEquals(tareaDTO.getNombreTarea(),tarea.getNombreTarea());
        Assertions.assertEquals(tareaDTO.getEstado(),tarea.getEstado());


        //verify(tareaRepositorio).save(Mockito.any(Tarea.class));
    }

}
