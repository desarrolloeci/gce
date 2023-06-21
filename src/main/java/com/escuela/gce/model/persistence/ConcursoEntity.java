package com.escuela.gce.model.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.escuela.gce.helper.constants.ConstantsTableNames;
import java.sql.Date;

@Entity
@Table(name = ConstantsTableNames.CONCURSOS, schema = ConstantsTableNames.SCHEMA)
public class ConcursoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_concurso", nullable = false, length = 19)
    private Integer id;

    @NotNull
    @Column(name = "id_eventoeci", nullable = true)
    private Integer idEventoeci;

    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "periodo", nullable = true)
    private String periodo;

    @NotNull
    @Column(name = "publico", nullable = false)
    private int publico;

    @NotNull
    @Column(name = "tipo_concurso", nullable = true)
    private Integer tipoConcurso;

    @NotNull
    @Column(name = "tipo", nullable = true)
    private Character tipo;

    @NotNull
    @Column(name = "activo", nullable = true)
    private Character activo;

    @NotNull
    @Column(name = "min_equipo", nullable = true)
    private Integer minEquipo;

    @NotNull
    @Column(name = "max_equipo", nullable = true)
    private Integer maxEquipo;

    @NotNull
    @Column(name = "valor", nullable = false)
    private int valor;

    @NotNull
    @Column(name = "valor_total", nullable = true)
    private Integer valorTotal;

    @NotNull
    @Column(name = "valor_total_ext", nullable = true)
    private Integer valorTotalExt;

    @NotNull
    @Column(name = "fecha_limpago", nullable = true)
    private Date fechaLimPago;

    @NotNull
    @Column(name = "fecha_limpago1", nullable = true)
    private Date fechaLimPago1;
    
    @NotNull
    @Column(name = "is_pago", nullable = true)
    private Character is_pago;

    public Character getIs_pago() {
        return is_pago;
    }

    public void setIs_pago(Character is_pago) {
        this.is_pago = is_pago;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEventoeci() {
        return idEventoeci;
    }

    public void setIdEventoeci(Integer idEventoeci) {
        this.idEventoeci = idEventoeci;
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

    public Integer getTipoConcurso() {
        return tipoConcurso;
    }

    public void setTipoConcurso(Integer tipoConcurso) {
        this.tipoConcurso = tipoConcurso;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public Integer getMinEquipo() {
        return minEquipo;
    }

    public void setMinEquipo(Integer minEquipo) {
        this.minEquipo = minEquipo;
    }

    public Integer getMaxEquipo() {
        return maxEquipo;
    }

    public void setMaxEquipo(Integer maxEquipo) {
        this.maxEquipo = maxEquipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getValorTotalExt() {
        return valorTotalExt;
    }

    public void setValorTotalExt(Integer valorTotalExt) {
        this.valorTotalExt = valorTotalExt;
    }

    public Date getFechaLimPago() {
        return fechaLimPago;
    }

    public void setFechaLimPago(Date fechaLimPago) {
        this.fechaLimPago = fechaLimPago;
    }

    public Date getFechaLimPago1() {
        return fechaLimPago1;
    }

    public void setFechaLimPago1(Date fechaLimPago1) {
        this.fechaLimPago1 = fechaLimPago1;
    }

    public ConcursoEntity() {
    }

    
}
