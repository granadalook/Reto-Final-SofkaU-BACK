package co.com.sofkau.appagilismo.historiadeusuario.repositorio;

import co.com.sofkau.appagilismo.historiadeusuario.coleccion.HistoriaDeUsuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaDeUsuarioRepositorio  extends ReactiveMongoRepository<HistoriaDeUsuario, String>{
}
