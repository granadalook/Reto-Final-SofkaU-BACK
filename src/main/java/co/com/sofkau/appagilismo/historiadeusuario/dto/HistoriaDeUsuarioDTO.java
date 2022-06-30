package co.com.sofkau.appagilismo.historiadeusuario.dto;

import co.com.sofkau.appagilismo.tarea.dto.TareaDTO;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HistoriaDeUsuarioDTO {
    private String historiaUsuarioId;

    @NotBlank
    private String tituloHistoriaUsuario;

    private String descripcion;

    @NotBlank
    private String estimacion;


    private String estado;

    private Integer porcentajeDeAvance;

    @NotBlank
    private String liderTecnicoId;

    @NotBlank
    private String desarrolladorId;

    @NotBlank
    private String proyectoId;

    private List<TareaDTO> tareas;

    public HistoriaDeUsuarioDTO() {
    }

    public HistoriaDeUsuarioDTO(String historiaUsuarioId,String tituloHistoriaUsuario, String descripcion, String estimacion, String estado, Integer porcentajeDeAvance,  String liderTecnicoId, String desarrolladorId , String proyectoId) {
        this.historiaUsuarioId = historiaUsuarioId;
        this.tituloHistoriaUsuario=tituloHistoriaUsuario;
        this.descripcion = descripcion;
        this.estimacion=estimacion;
        this.estado=estado;
        this.porcentajeDeAvance=porcentajeDeAvance;
        this.liderTecnicoId=liderTecnicoId;
        this.desarrolladorId=desarrolladorId;
        this.proyectoId=proyectoId;

    }

    public HistoriaDeUsuarioDTO(String tituloHistoriaUsuario, String estimacion, String estado, String liderTecnicoId, String desarrolladorId, String proyectoId) {
        this.tituloHistoriaUsuario=tituloHistoriaUsuario;
        this.estimacion = estimacion;
        this.estado=estado;
        this.liderTecnicoId=liderTecnicoId;
        this.desarrolladorId=desarrolladorId;
        this.proyectoId=proyectoId;

    }

    public String getHistoriaUsuarioId() {
        return historiaUsuarioId;
    }

    public String getTituloHistoriaUsuario() {
        return tituloHistoriaUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstimacion() {
        return estimacion;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getPorcentajeDeAvance() {
        return porcentajeDeAvance;
    }

    public String getLiderTecnicoId() {
        return liderTecnicoId;
    }

    public String getDesarrolladorId() {
        return desarrolladorId;
    }

    public String getProyectoId() {
        return proyectoId;
    }

    public List<TareaDTO> getTareas()
    {
        this.tareas= Optional.ofNullable(tareas).orElse(new ArrayList<>());
        return tareas;
    }

    public void setTareas(List<TareaDTO> tareas) {
        this.tareas = tareas;
    }
}
