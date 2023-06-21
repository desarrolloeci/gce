package com.escuela.gce.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonPropertyOrder({ "codigo" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseListadoAsistenciaDTO {

    @JsonProperty("codigo")
    private int codigo;

    @JsonProperty("mensaje")
    private String mensaje;

    @JsonProperty("listaAsistencia")
    private List<AsistenciaMapperDTO> listaAsistencia;

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

    public List<AsistenciaMapperDTO> getListaAsistencia() {
        return listaAsistencia;
    }

    public void setListaAsistencia(List<AsistenciaMapperDTO> listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }
    
    public ResponseListadoAsistenciaDTO() {
    }

}
