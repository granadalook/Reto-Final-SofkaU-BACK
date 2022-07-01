package co.com.sofkau.appagilismo.proyecto.casos_de_uso;

import co.com.sofkau.appagilismo.proyecto.coleccion.Proyecto;
import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import co.com.sofkau.appagilismo.proyecto.mapper.MapperProyecto;
import co.com.sofkau.appagilismo.proyecto.repositorio.ProyectoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class CrearProyectoCasoDeUsoTest {
    @Autowired
    ProyectoRepositorio proyectoRepositorio;
    @Autowired
    MapperProyecto mapperProyecto;
    @Autowired
    CrearProyectoCasoDeUso crearProyectoCasoDeUso;

    private static final String proyectoId = "00001";
    private static final String nombre = "SofkaUIngreso";
    private static final String arquitectoId = "Raul";
    private static final String liderTecnicoId = "Eddi";

    @BeforeEach
    public void ConfiguracionMock () {
        proyectoRepositorio = mock(ProyectoRepositorio.class);
        crearProyectoCasoDeUso = new CrearProyectoCasoDeUso(proyectoRepositorio,mapperProyecto);
    }

    @Test
    void crearProyectoTest(){
        var proyecto = new Proyecto();
        proyecto.setNombre(nombre);
        proyecto.setArquitectoId(arquitectoId);
        proyecto.setLiderTecnicoId(liderTecnicoId);

        var proyectoDTO = new ProyectoDTO();
        proyectoDTO.setNombre(nombre);
        proyectoDTO.setArquitectoId(arquitectoId);
        proyectoDTO.setLiderTecnicoId(liderTecnicoId);

        Assertions.assertEquals(proyectoDTO.getArquitectoId(),proyecto.getArquitectoId());

    }



}
