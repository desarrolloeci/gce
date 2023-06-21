package com.escuela.gce.model.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.escuela.gce.helper.constants.ConstantsTableNames;
import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = ConstantsTableNames.ASISTENCIA, schema = ConstantsTableNames.SCHEMA)
@XmlRootElement
public class AsistenciaEntity implements Serializable {

    @Id
    @NotNull
    @Column(name = "id_asistencia", nullable = false, length = 19)
    private Integer id;

    @NotNull
    @Column(name = "id_concurso", nullable = false, length = 19)
    private Integer idConcurso;
    
    @NotNull
    @Column(name = "id_participante", nullable = false, length = 19)
    private String idParticipante;

    @NotNull
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;
    

    public AsistenciaEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(Integer idConcurso) {
        this.idConcurso = idConcurso;
    }

    public String getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(String idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    

}
