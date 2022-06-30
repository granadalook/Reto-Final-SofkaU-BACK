package co.com.sofkau.appagilismo.proyecto.dto;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProyectoDTO {



    private String proyectoId;

    @NotBlank
    private String nombre;

    @NotBlank
    private String arquitectoId;

    @NotBlank
    private String liderTecnicoId;

    private Integer porcentajeDeAvance;

    private Boolean estado;

    private List<String> historias_de_usuarios;

    public ProyectoDTO() {
    }

    public ProyectoDTO(String proyectoId, String nombre, String arquitectoId, String liderTecnicoId, Integer porcentajeDeAvance, Boolean estado) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
        this.arquitectoId = arquitectoId;
        this.liderTecnicoId = liderTecnicoId;
        this.porcentajeDeAvance = porcentajeDeAvance;
        this.estado = estado;
    }

    public ProyectoDTO(String nombre, String arquitectoId, String liderTecnicoId) {
        this.nombre = nombre;
        this.arquitectoId = arquitectoId;
        this.liderTecnicoId = liderTecnicoId;
    }

    public String getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(String proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getHistorias_de_usuarios() {
        this.historias_de_usuarios = Optional.ofNullable(historias_de_usuarios).orElse(new ArrayList<>());
        return historias_de_usuarios;
    }

    public void setHistorias_de_usuarios(List<String> historias_de_usuarios) {
        this.historias_de_usuarios = historias_de_usuarios;
    }

    public String getArquitectoId() {
        return arquitectoId;
    }

    public void setArquitectoId(String arquitectoId) {
        this.arquitectoId = arquitectoId;
    }

    public String getLiderTecnicoId() {
        return liderTecnicoId;
    }

    public void setLiderTecnicoId(String liderTecnicoId) {
        this.liderTecnicoId = liderTecnicoId;
    }

    public Integer getPorcentajeDeAvance() {
        return porcentajeDeAvance;
    }

    public void setPorcentajeDeAvance(Integer porcentajeDeAvance) {
        this.porcentajeDeAvance = porcentajeDeAvance;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
