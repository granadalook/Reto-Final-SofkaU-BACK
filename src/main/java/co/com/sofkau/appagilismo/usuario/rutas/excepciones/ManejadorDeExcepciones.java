package co.com.sofkau.appagilismo.usuario.rutas.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Date;

@RestControllerAdvice
public class ManejadorDeExcepciones {


   @ExceptionHandler(ExcepcionCampoNombreCompletoVacio.class)
   @ResponseStatus(value = HttpStatus.NOT_FOUND)
   public ErrorMessage excepcionCampoNombreCompletoVacio(ServerRequest request, ExcepcionCampoNombreCompletoVacio excepcion){
      ErrorMessage message = new ErrorMessage(
              HttpStatus.NOT_FOUND.value(),
              new Date(),
              excepcion.getMessage());

      return message;
   }

/*
   @ResponseStatus(HttpStatus.NOT_FOUND)
   @ExceptionHandler
   public ErrorMessage excepcionCampoEmailVacio(HttpServletRequest request, Exception excepcion){
      return new ErrorMessage(excepcion, request.getRequestURI());
   }*/
}
