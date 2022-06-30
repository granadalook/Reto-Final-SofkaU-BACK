package co.com.sofkau.appagilismo.tarea.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso.AsociarHistoriaDeUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import co.com.sofkau.appagilismo.tarea.mapper.MapperTarea;
import co.com.sofkau.appagilismo.tarea.repositorio.TareaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@Validated
public class EditarTareaCasoDeUso implements EditarTareaInterface {
    private final TareaRepositorio tareaRepositorio;
    private final MapperTarea mapperTarea;
    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;
    private final AsociarHistoriaDeUsuarioCasoDeUso asociarHistoriaDeUsuarioCasoDeUso;

    public EditarTareaCasoDeUso(TareaRepositorio tareaRepositorio, MapperTarea mapperTarea,MapperHistoriaDeUsuario mapperHistoriaDeUsuario ,AsociarHistoriaDeUsuarioCasoDeUso asociarHistoriaDeUsuarioCasoDeUso) {
        this.tareaRepositorio = tareaRepositorio;
        this.mapperTarea = mapperTarea;
        this.mapperHistoriaDeUsuario = mapperHistoriaDeUsuario;
        this.asociarHistoriaDeUsuarioCasoDeUso = asociarHistoriaDeUsuarioCasoDeUso;
    }


    @Override
    public Mono<HistoriaDeUsuarioDTO> editarTarea(TareaDTO tareaDTO) {
        return asociarHistoriaDeUsuarioCasoDeUso.apply(tareaDTO.getHistoriaUsuarioId())
                .flatMap(historiadeUsuario ->
                        tareaRepositorio.save(mapperTarea.mapperATarea(tareaDTO.getTareaId()).apply(tareaDTO))
                                .map(tarea -> {
                                    historiadeUsuario.getTareas().add(
                                            mapperTarea.mapperATareaDTO().apply(tarea)
                                    );
                                    return historiadeUsuario;
                                })
                );

    }
}
       /*
return getUseCase.apply(answerDTO.getQuestionId())
                .flatMap(question ->
                        answerRepository.save(mapperUtilsAnswer.mapperToAnswer().apply(answerDTO))
                                .map(answer -> {
                                    question.getAnswers().add(
                                            mapperUtilsAnswer.mapEntityToAnswer().apply(answer)
                                    );
                                    return question;
                                })
                );
         */
