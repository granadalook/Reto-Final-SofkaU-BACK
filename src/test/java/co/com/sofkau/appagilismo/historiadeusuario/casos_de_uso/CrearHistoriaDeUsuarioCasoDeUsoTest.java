package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import co.com.sofkau.appagilismo.tarea.casos_de_uso.CrearTareaCasoDeUso;
import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.annotation.Id;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import javax.validation.constraints.NotBlank;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 /* @Autowired
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
       *//* var historiaDeUsuario = new HistoriaDeUsuario();
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

        verify(repositorio).save(Mockito.any(HistoriaDeUsuario.class));*//*
    }*/

@SpringBootTest
class CrearHistoriaDeUsuarioCasoDeUsoTest {

    @Autowired
    ProyectoRepositorio proyectoRepositorio;
    @Autowired
    HistoriaDeUsuarioDTO historiaDeUsuarioDTO;
    @Autowired
    CrearHistoriaDeUsuarioCasoDeUso crearHistoriaDeUsuarioCasoDeUso;
    @Autowired
    MapperHistoriaDeUsuario mapperHistoriaDeUsuario;
    @Autowired
    TareaRepositorio tareaRepositorio;
    @Autowired
    MapperTarea mapperTarea;
    @Autowired
    HistoriaDeUsuarioRepositorio historiaDeUsuarioRepositorio;

    private static final String historiaUsuarioId = "00001";
    private static final String tituloHistoriaUsuario = "HistoriaDeUsuarioTest";
    private static final String estimacion = "8";
    private static final String estado = "TODO";
    private static final Integer porcentajeDeAvance = 10;
    private static final String liderTecnicoId = "Manuel Salas";
    private static final String desarrolladorId = "Edgar M";
    private static final String proyectoId = "Agilismo";
    private static final String descripcionTarea = "Realizar prueba a 'CrearTareaUsoDeCaso'.";


 @BeforeEach
 public void ConfiguracionMock (){
  tareaRepositorio = mock(TareaRepositorio.class);
  historiaDeUsuarioRepositorio = mock(HistoriaDeUsuarioRepositorio.class);
  crearHistoriaDeUsuarioCasoDeUso = new CrearHistoriaDeUsuarioCasoDeUso(historiaDeUsuarioRepositorio, mapperHistoriaDeUsuario, tareaRepositorio, mapperTarea);

 }
 @Test
 void CrearHistoriaDeUsuarioTest(){
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

  when(historiaDeUsuarioRepositorio.save(Mockito.any(HistoriaDeUsuario.class))).thenReturn(Mono.just(historiaDeUsuario));
  when(tareaRepositorio.save(Mockito.any(Tarea.class))).thenReturn(Mono.just(tarea));



  //Assertions.assertNotNull(historiaDeUsuarioDTO);
  //Assertions.assertNotNull(historiaDeUsuario);
  //Assertions.assertNotNull(tareaDTO);
  //Assertions.assertNotNull(tarea);
  //Assertions.assertEquals(tareaDTO.getHistoriaUsuarioId(),tarea.getHistoriaUsuarioId());




 }

}