package co.com.sofkau.appagilismo.usuario.rutas;


import co.com.sofkau.appagilismo.usuario.casos_de_uso.CrearUsuarioCasoDeUso;
import co.com.sofkau.appagilismo.usuario.casos_de_uso.LogInCasoDeUso;
import co.com.sofkau.appagilismo.usuario.dto.UsuarioDTO;
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
                Function<UsuarioDTO, Mono<ServerResponse>> logIn = usuarioDTO -> logInCasoDeUso.logIn(usuarioDTO)
                .flatMap(resultado -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(resultado)
                );
            return route(GET("/usuario/login").and(accept(MediaType.APPLICATION_JSON)),
                    request -> request.bodyToMono(UsuarioDTO.class)
                            .flatMap(logIn)
            );
    }

    /*@Bean
    public RouterFunction<ServerResponse> add(UsuarioCasosDeUsos usuarioCasosDeUsos){
        return route(
                GET("/getOwnerAll/{userId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                usuarioCasosDeUsos.apply(request.pathVariable("userId")),
                                String.class)));
    }*/
}