package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.AsociarHistoriaDeUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Service
@Validated
public class CrearTareaCasoDeUso implements CrearTareaInterface {

    private final TareaRepositorio tareaRepositorio;
    private final MapperTarea mapperTarea;
    private final AsociarHistoriaDeUsuarioCasoDeUso asociarHistoriaDeUsuarioCasoDeUso;

    public CrearTareaCasoDeUso(TareaRepositorio tareaRepositorio, MapperTarea mapperTarea, AsociarHistoriaDeUsuarioCasoDeUso asociarHistoriaDeUsuarioCasoDeUso) {
        this.tareaRepositorio = tareaRepositorio;
        this.mapperTarea = mapperTarea;
        this.asociarHistoriaDeUsuarioCasoDeUso=asociarHistoriaDeUsuarioCasoDeUso;
    }

    @Override
    public Mono<HistoriaDeUsuarioDTO> crearTarea(TareaDTO tareaDTO) {
        Objects.requireNonNull(tareaDTO.getHistoriaUsuarioId(),"Id de tarea es obligatorio.");
        return asociarHistoriaDeUsuarioCasoDeUso.apply(tareaDTO.getHistoriaUsuarioId()).flatMap(historiaDeUsuario ->
                tareaRepositorio.save(mapperTarea.mapperATarea().apply(tareaDTO))
                        .map(tarea -> {
                            historiaDeUsuario.getTareas().add(tareaDTO);
                            return historiaDeUsuario;
                        })
                );
    }
}
