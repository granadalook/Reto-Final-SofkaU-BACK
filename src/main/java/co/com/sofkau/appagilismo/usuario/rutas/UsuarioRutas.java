package co.com.sofkau.appagilismo.usuario.rutas;

import co.com.sofkau.appagilismo.usuario.casos_de_uso.CrearUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UsuarioRutas {

    @Bean
    public RouterFunction<ServerResponse> crearusuario(CrearUsuarioCasoDeUso crearUsuarioCasoDeUso){
        return (POST("usuario/crear").and(accept(MediaType.APPLICATION_JSON)),
            request -> request.bodyToMono(UsuarioDTO.class)
                    .flatMap(crearUsuarioCasoDeUso::crearUsuario)
                    .flatMap(resultado -> ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(resultado)
                            .onErrorResume(throwable -> ServerResponse.badRequest()
                                            .body(throwable.getMessage(), String.class))
                    )
        );
    }
}

