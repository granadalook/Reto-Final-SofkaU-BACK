package co.com.sofkau.appagilismo.usuario.repositorio;

import co.com.sofkau.appagilismo.tarea.colleccion.Tarea;
import co.com.sofkau.appagilismo.usuario.coleccion.Usuario;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioLogin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UsuarioRepositorio extends ReactiveMongoRepository<Usuario, String> {

    Mono<UsuarioDTO> findByEmailAndPassword(String email, String password);
    Flux<Usuario> findAllByRol(String rol);
}
