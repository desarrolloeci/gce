package com.escuela.gce.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConcursoDTO {

    @JsonProperty("id_concurso")
    private int id_concurso;

    @JsonProperty("id_eventoeci")
    private int id_eventoeci;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("publico")
    private int publico;

    @JsonProperty("tipo_concurso")
    private int tipo_concurso;

    @JsonProperty("tipo")
    private char tipo;

    @JsonProperty("activo")
    private char activo;

    @JsonProperty("min_equipo")
    private int min_equipo;

    @JsonProperty("max_equipo")
    private int max_equipo;

    @JsonProperty("valor")
    private int valor;

    @JsonProperty("valor_total")
    private int valor_total;

    @JsonProperty("valor_total_ext")
    private int valor_total_ext;

    @JsonProperty("fecha_limpago")
    private String fecha_limpago;

    @JsonProperty("fecha_limpago1")
    private String fecha_limpago1;
    
    @JsonProperty("is_pago")
    private char is_pago;

    public char getIs_pago() {
        return is_pago;
    }

    public void setIs_pago(char is_pago) {
        this.is_pago = is_pago;
    }

    public int getId_concurso() {
        return id_concurso;
    }

    public void setId_concurso(int id_concurso) {
        this.id_concurso = id_concurso;
    }

    public int getId_eventoeci() {
        return id_eventoeci;
    }

    public void setId_eventoeci(int id_eventoeci) {
        this.id_eventoeci = id_eventoeci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getPublico() {
        return publico;
    }

    public void setPublico(int publico) {
        this.publico = publico;
    }

    public int getTipo_concurso() {
        return tipo_concurso;
    }

    public void setTipo_concurso(int tipo_concurso) {
        this.tipo_concurso = tipo_concurso;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public int getMin_equipo() {
        return min_equipo;
    }

    public void setMin_equipo(int min_equipo) {
        this.min_equipo = min_equipo;
    }

    public int getMax_equipo() {
        return max_equipo;
    }

    public void setMax_equipo(int max_equipo) {
        this.max_equipo = max_equipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor_total() {
        return valor_total;
    }

    public void setValor_total(int valor_total) {
        this.valor_total = valor_total;
    }

    public int getValor_total_ext() {
        return valor_total_ext;
    }

    public void setValor_total_ext(int valor_total_ext) {
        this.valor_total_ext = valor_total_ext;
    }

    public String getFecha_limpago() {
        return fecha_limpago;
    }

    public void setFecha_limpago(String fecha_limpago) {
        this.fecha_limpago = fecha_limpago;
    }

    public String getFecha_limpago1() {
        return fecha_limpago1;
    }

    public void setFecha_limpago1(String fecha_limpago1) {
        this.fecha_limpago1 = fecha_limpago1;
    }

    

   

    public ConcursoDTO() {
    }

}
