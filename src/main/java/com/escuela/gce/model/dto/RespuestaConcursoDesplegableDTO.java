package com.escuela.gce.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.Date;
import java.util.List;

@JsonPropertyOrder({ "lista" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespuestaConcursoDesplegableDTO {

    @JsonProperty("codigo")
    private int codigo;

    @JsonProperty("mensaje")
    private String mensaje;

    @JsonProperty("listaConcursos")
    private List<ConcursoDesplegableDTO> listaConcursos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<ConcursoDesplegableDTO> getListaConcursos() {
        return listaConcursos;
    }

    public void setListaConcursos(List<ConcursoDesplegableDTO> listaConcursos) {
        this.listaConcursos = listaConcursos;
    }

    

    
    
   public RespuestaConcursoDesplegableDTO() {
    }

}
