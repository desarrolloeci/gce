package com.escuela.gce.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestAsistenciaDTO {

    @JsonProperty("id_concurso")
    private Integer id_concurso;

    

    @JsonProperty("cedula")
    private String cedula;

    

    public int getId_concurso() {
        return id_concurso;
    }

    public void setId_concurso(int id_concurso) {
        this.id_concurso = id_concurso;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

   


   public RequestAsistenciaDTO() {
    }

}
