package co.com.sofkau.appagilismo.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ExcepcionPersonalizadaInternalServerError extends RuntimeException{

    private static final long serialVersionUID = -1121780651598940958L;

    public ExcepcionPersonalizadaInternalServerError(String message) {
        super(message);
    }
}

