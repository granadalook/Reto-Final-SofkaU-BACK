package co.com.sofkau.appagilismo.historiadeusuario.repositorio;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Representa a una interfaz que hereda de la interfaz ReactiveMongoRepository que tiene SpringBoot, todos sus metodos.
 */
@Repository
public interface HistoriaDeUsuarioRepositorio  extends ReactiveMongoRepository<HistoriaDeUsuario, String>{

    /**
     * Metodo que permite borrar un proyecto por su Id.
     * @param idProyecto
     * @return Mono<Void>
     */
    Mono<Void> deleteByProyectoId(String idProyecto);

    /**
     * Metodo que permite traer una lista de todas las historias de usuario vinculadas a un usuario de rol Lider Tecnico
     * por su Id.
     * @param liderTecnicoId
     * @return Lista de objetos de Historias de usuarios.
     */
    Flux<HistoriaDeUsuario> findAllByLiderTecnicoId(String liderTecnicoId);

    /**
     * Metodo que permite traer una lista de todas las historias de usuario vinculadas a un usuario de rol desarrollador
     * por su Id.
     * @param desarrolladorId
     * @return Lista de objetos de Historias de usuarios.
     */
    Flux<HistoriaDeUsuario> findAllByDesarrolladorId(String desarrolladorId);
}
