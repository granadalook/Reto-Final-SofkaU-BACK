package co.com.sofkau.appagilismo.usuario.rutas.excepciones;

import java.util.Date;

public class ErrorMessage {

    private Integer statusCode;
    private Date timeStamp;
    private String message;


    public ErrorMessage(Integer statusCode, Date timeStamp, String message) {
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
        this.message = message;

    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

}
