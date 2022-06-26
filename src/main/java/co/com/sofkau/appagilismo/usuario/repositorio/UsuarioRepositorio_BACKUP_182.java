package co.com.sofkau.appagilismo.usuario.repositorio;

import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UsuarioRepositorio extends ReactiveMongoRepository<Usuario, String> {
    Mono<UsuarioDTO> findByEmail (String email);

}
