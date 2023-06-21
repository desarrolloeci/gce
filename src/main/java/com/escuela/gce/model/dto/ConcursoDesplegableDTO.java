package com.escuela.gce.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConcursoDesplegableDTO {

    @JsonProperty("idConcurso")
    private Integer idConcurso;

    @JsonProperty("nombre")
    private String nombre;

    public Integer getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(Integer idConcurso) {
        this.idConcurso = idConcurso;
    }

    

    

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   public ConcursoDesplegableDTO() {
    }

}
