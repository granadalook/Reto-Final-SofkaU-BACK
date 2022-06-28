package co.com.sofkau.appagilismo.usuario.rutas;


import co.com.sofkau.appagilismo.usuario.casos_de_uso.CrearUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.usuario.casos_de_uso.LogInCasoDeUso;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioLogin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UsuarioRutas {

    @Bean
    public RouterFunction<ServerResponse> crearUsuario(CrearUsuarioCasoDeUso crearUsuarioCasoDeUso){
        Function<UsuarioDTO, Mono<ServerResponse>> crearUsuario = usuarioDTO -> crearUsuarioCasoDeUso.crearUsuario(usuarioDTO)
                .flatMap(resultado -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(resultado)
                );
        return route(POST("/usuario/crear").and(accept(MediaType.APPLICATION_JSON)),
            request -> request.bodyToMono(UsuarioDTO.class)
                    .flatMap(crearUsuario)
        );
    }
    @Bean
    public RouterFunction<ServerResponse> Login(LogInCasoDeUso logInCasoDeUso){
        Function<UsuarioLogin, Mono<ServerResponse>> logIn = usuarioLogin -> logInCasoDeUso.logIn(usuarioLogin)
                .flatMap(resultado -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(resultado)
                );

        return route(POST("/login").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UsuarioLogin.class)
                        .flatMap(logIn)
                            /*.flatMap(dato -> {
                                Optional<String> email = request.queryParam("email");
                                Optional<String> password = request.queryParam("password");
                                if(email.isEmpty() || password.equals(null)){
                                    log.info("entro al if {}");
                                    throw  new ExcepcionPersonalizadaInternalServerError("Email o contraseña vacío");
                                }
                                throw new ExcepcionPersonalizadaInternalServerError("Formato de email invalido");
                            })*/
        );
    }

}