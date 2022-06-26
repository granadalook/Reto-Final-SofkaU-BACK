package co.com.sofkau.appagilismo.usuario.rutas.excepciones;

public class ExcepcionBadRequest extends RuntimeException{

    private static final String DESCRIPCION = "Excepcion Bad Request (400)";

    public ExcepcionBadRequest(String detalle){
        super(DESCRIPCION + ", " + detalle);
    }
}
