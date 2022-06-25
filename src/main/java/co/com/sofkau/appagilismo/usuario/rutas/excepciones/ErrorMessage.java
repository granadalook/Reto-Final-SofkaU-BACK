package co.com.sofkau.appagilismo.usuario.rutas.excepciones;

public class ErrorMessage {

    private String excepcion;
    private String mensaje;

    public ErrorMessage(Exception excepcion, String mensaje){
        this.excepcion=excepcion.getClass().getSimpleName();
        this.mensaje=excepcion.getMessage();
    }

    public String getExcepcion() {
        return excepcion;
    }

    public void setExcepcion(String excepcion) {
        this.excepcion = excepcion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "excepcion='" + excepcion + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
