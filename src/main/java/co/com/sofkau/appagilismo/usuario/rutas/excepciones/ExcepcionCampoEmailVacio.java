package co.com.sofkau.appagilismo.usuario.rutas.excepciones;

public class ExcepcionCampoEmailVacio extends RuntimeException{

    private static final String DESCRIPCION = "El email no puede estar vacio";

    public ExcepcionCampoEmailVacio(){
        super(DESCRIPCION);
    }
}
