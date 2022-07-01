package co.com.sofkau.appagilismo.proyecto.repositorio;

import co.com.sofkau.appagilismo.proyecto.coleccion.Proyecto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Representa a una interfaz que hereda de la interfaz ReactiveMongoRepository que tiene SpringBoot, todos sus metodos.
 */
@Repository
public interface ProyectoRepositorio extends ReactiveMongoRepository<Proyecto, String> {
}
