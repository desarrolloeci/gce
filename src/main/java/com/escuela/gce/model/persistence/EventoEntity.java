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
@Table(name = ConstantsTableNames.EVENTOS, schema = ConstantsTableNames.SCHEMA)
public class EventoEntity implements Serializable {

    @Id
    @NotNull
     @Column(name = "id_evento", nullable = false, length = 19)
    private int id;

    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "periodo", nullable = false, length = 6)
    private String periodo;

    @NotNull
    @Column(name = "activo", nullable = true)
    private Character activo;

    @NotNull
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @NotNull
    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    public EventoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
