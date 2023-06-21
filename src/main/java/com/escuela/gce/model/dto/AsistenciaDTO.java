package com.escuela.gce.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AsistenciaDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nombres")
    private String nombres;

    @JsonProperty("fecha_inicio")
    private Date fecha_inicio;

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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public AsistenciaDTO() {
    }

}
