package co.com.sofkau.appagilismo.proyecto.repositorio;

import co.com.sofkau.appagilismo.proyecto.coleccion.Proyecto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepositorio extends ReactiveMongoRepository<Proyecto, String> {
}
