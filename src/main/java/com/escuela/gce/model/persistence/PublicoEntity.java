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

@Entity
@Table(name = ConstantsTableNames.TIPOS_PUBLICO, schema = ConstantsTableNames.SCHEMA)
public class PublicoEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publico", nullable = false, length = 19)
    private int id;

    @Null
    @Column(name = "nombre", nullable = true)
    private String nombre;

    public PublicoEntity() {
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

}
