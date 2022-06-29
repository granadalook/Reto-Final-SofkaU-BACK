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


    private boolean estado;

    private Integer porcentajeDeAvance;

    @NotBlank
    private String liderTecnicoId;

    @NotBlank
    private String creadoPor;

    @NotBlank
    private String proyectoId;

    private List<TareaDTO> tareas;

    public HistoriaDeUsuarioDTO() {
    }

    public HistoriaDeUsuarioDTO(String historiaUsuarioId,String tituloHistoriaUsuario, String descripcion, String estimacion, boolean estado, Integer porcentajeDeAvance,  String liderTecnicoId, String creadoPor , String proyectoId) {
        this.historiaUsuarioId = historiaUsuarioId;
        this.tituloHistoriaUsuario=tituloHistoriaUsuario;
        this.descripcion = descripcion;
        this.estimacion=estimacion;
        this.estado=estado;
        this.porcentajeDeAvance=porcentajeDeAvance;
        this.liderTecnicoId=liderTecnicoId;
        this.creadoPor=creadoPor;
        this.proyectoId=proyectoId;

    }

    public HistoriaDeUsuarioDTO(String tituloHistoriaUsuario, String estimacion, String liderTecnicoId, String creadoPor, String proyectoId) {
        this.tituloHistoriaUsuario=tituloHistoriaUsuario;
        this.estimacion = estimacion;
        this.liderTecnicoId=liderTecnicoId;
        this.creadoPor=creadoPor;
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

    public boolean isEstado() {
        return estado;
    }

    public Integer getPorcentajeDeAvance() {
        return porcentajeDeAvance;
    }

    public String getLiderTecnicoId() {
        return liderTecnicoId;
    }

    public String getCreadoPor() {
        return creadoPor;
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
