package co.com.sofkau.appagilismo.proyecto.repositorio;

import co.com.sofkau.appagilismo.proyecto.coleccion.Proyecto;
import co.com.sofkau.appagilismo.proyecto.dto.ProyectoDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProyectoRepositorio extends ReactiveMongoRepository<Proyecto, String> {
}
