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
@Table(name = ConstantsTableNames.INSCRITOS, schema = ConstantsTableNames.SCHEMA)
public class InscritoEntity implements Serializable {

 
    @NotNull
    @Column(name = "id_inscripcion", nullable = false, length = 19)
    private Integer id;

    @NotNull
    @Column(name = "id_concurso", nullable = false)
    private Integer idConcurso;
    
    
    @Id
    @Null
    @Column(name = "docum", nullable = true)
    private String docum;

    @Null
    @Column(name = "nombres", nullable = true)
    private String nombres;

    @Null
    @Column(name = "apellido1", nullable = true)
    private String apellido1;

    @Null
    @Column(name = "apellido2", nullable = true)
    private String apellido2;

    @Null
    @Column(name = "direccion", nullable = true)
    private String direccion;

    @Null
    @Column(name = "telefono", nullable = true)
    private String telefono;

    @Null
    @Column(name = "celular", nullable = true)
    private String celular;

    @Null
    @Column(name = "tip_doc", nullable = true)
    private String tipDoc;

    @Null
    @Column(name = "institucion", nullable = true)
    private String institucion;

    @Null
    @Column(name = "participo", nullable = true)
    private String participo;

    @Null
    @Column(name = "nom_grupo", nullable = true)
    private String nomGrupo;

    @Null
    @Column(name = "carrera", nullable = true)
    private String carrera;

    @Null
    @Column(name = "periodo", nullable = true, length = 6)
    private String periodo;

    @Null
    @Column(name = "ciudad", nullable = true)
    private String ciudad;

    @Null
    @Column(name = "email", nullable = true)
    private String email;

    @Null
    @Column(name = "num_orden", nullable = true)
    private String numOrden;

    @Null
    @Column(name = "carne", nullable = true)
    private Long carne;

    @Null
    @Column(name = "tipo_partic", nullable = true)
    private String tipoPartic;

    @Null
    @Column(name = "fecha", nullable = true)
    private Date fecha;

    @Null
    @Column(name = "grado", nullable = true)
    private String grado;

    @Null
    @Column(name = "codigo_area", nullable = true)
    private String codigoArea;

    @Null
    @Column(name = "fecha_nac", nullable = true)
    private Date fechaNac;
    
    
    @Null
    @Column(name = "pago", nullable = true)
    private Integer pago_orden;

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

    public Long getCarne() {
        return carne;
    }

    public void setCarne(Long carne) {
        this.carne = carne;
    }

    

    public String getDocum() {
        return docum;
    }

    public void setDocum(String docum) {
        this.docum = docum;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getParticipo() {
        return participo;
    }

    public void setParticipo(String participo) {
        this.participo = participo;
    }

    public String getNomGrupo() {
        return nomGrupo;
    }

    public void setNomGrupo(String nomGrupo) {
        this.nomGrupo = nomGrupo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

    

    public String getTipoPartic() {
        return tipoPartic;
    }

    public void setTipoPartic(String tipoPartic) {
        this.tipoPartic = tipoPartic;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
   

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    
      public Integer getpago() {
        return pago_orden;
    }

    public void setpago(Integer pago_orden) {
        this.pago_orden = pago_orden;
    }

    public InscritoEntity() {
    }

}
