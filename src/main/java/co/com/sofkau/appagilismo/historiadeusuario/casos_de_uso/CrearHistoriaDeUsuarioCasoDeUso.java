package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class CrearHistoriaDeUsuarioCasoDeUso implements CrearHistoriaDeUsuarioInterface{

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    private final TareaRepositorio tareaRepositorio;

    private final MapperTarea mapperTarea;

    public CrearHistoriaDeUsuarioCasoDeUso(HistoriaDeUsuarioRepositorio repositorio,MapperHistoriaDeUsuario mapperHistoriaDeUsuario, TareaRepositorio tareaRepositorio, MapperTarea mapperTarea) {
        this.repositorio = repositorio;
        this.mapperHistoriaDeUsuario=mapperHistoriaDeUsuario;
        this.tareaRepositorio=tareaRepositorio;
        this.mapperTarea=mapperTarea;
    }

    @Override
    public Mono<HistoriaDeUsuarioDTO> crearHistoriaDeUsuario(HistoriaDeUsuarioDTO historiaDeUsuarioDTO){
       return repositorio
                .save(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuario(null).apply(historiaDeUsuarioDTO))
               .map(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuarioDTO());
    }

}
