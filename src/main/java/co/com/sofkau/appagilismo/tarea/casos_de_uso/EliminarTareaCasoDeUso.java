package co.com.sofkau.appagilismo.tarea.casos_de_uso;


import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class EliminarTareaCasoDeUso implements EliminarTareaInterface {

    @Override
    public Mono<Void> eliminarTarea(TareaDTO tareaDTO) {
        return null;
    }
}
