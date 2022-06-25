package co.com.sofkau.appagilismo.usuario.repositorio;

import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends ReactiveMongoRepository<Usuario, String> {
}
