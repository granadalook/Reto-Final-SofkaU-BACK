package co.com.sofkau.appagilismo.utilidades;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;

/**
 * Clase que permite calcular el porcentaje de avance en las historias de usuario.
 */
public class CalcularPorcentajeDeAvance {

    /**
     * Metodo que permite clacular el porcentaje de avance de las historias de usuario.
     * @param historiaDeUsuarioDTO
     * @return Un numero entero.
     */
    public Integer calcularPorcentajeDeAvance(HistoriaDeUsuarioDTO historiaDeUsuarioDTO){
        Double completas = Double.valueOf(historiaDeUsuarioDTO.getTareas().stream().filter(tarea -> {
            return tarea.isCompleta()==true;
        }).count());

        Double total = Double.valueOf(historiaDeUsuarioDTO.getTareas().size())-1;

        return Math.toIntExact((long) ((completas/total)*100));
    }
}
