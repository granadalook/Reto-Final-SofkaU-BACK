package co.com.sofkau.appagilismo.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExcepcionPersonalizadaBadRequest extends RuntimeException{

    private static final long serialVersionUID = 7478152478564113226L;

    public ExcepcionPersonalizadaBadRequest(String message) {
        super(message);
    }
}

