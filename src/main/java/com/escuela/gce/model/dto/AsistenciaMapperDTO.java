package com.escuela.gce.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AsistenciaMapperDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nombres")
    private String nombres;
    
    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("fechaInicio")
    private Date fechaInicio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    

    public AsistenciaMapperDTO() {
    }

    public AsistenciaMapperDTO(Integer id, String nombres, String apellido, Date fechaInicio) {
        this.id = id;
        this.nombres = nombres;
        this.apellido = apellido;
        this.fechaInicio = fechaInicio;
    }

    

    
    
}
