package com.escuela.gce.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublicoDTO {

    @JsonProperty("id_publico")
    private int id_publico;

    @JsonProperty("nombre")
    private String nombre;

    public int getId_publico() {
        return id_publico;
    }

    public void setId_publico(int id_publico) {
        this.id_publico = id_publico;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PublicoDTO() {
    }

}
