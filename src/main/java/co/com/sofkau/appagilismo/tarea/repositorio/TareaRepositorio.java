package co.com.sofkau.appagilismo.tarea.repositorio;

import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepositorio extends ReactiveMongoRepository<Tarea, String> {

}
