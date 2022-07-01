package co.com.sofkau.appagilismo.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExcepcionPersonalizadaNotFound extends RuntimeException{

    private static final long serialVersionUID = -5620959139754471404L;

    public ExcepcionPersonalizadaNotFound(String message) {
        super(message);
    }
}

