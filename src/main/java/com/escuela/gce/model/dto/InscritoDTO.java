package com.escuela.gce.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InscritoDTO {

    @JsonProperty("id_inscripcion")
    private Integer id_inscripcion;

    @JsonProperty("id_concurso")
    private Integer id_concurso;

    @JsonProperty("docum")
    private String docum;

    @JsonProperty("nombres")
    private String nombres;

    @JsonProperty("apellido1")
    private String apellido1;

    @JsonProperty("apellido2")
    private String apellido2;

    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("celular")
    private String celular;

    @JsonProperty("tip_doc")
    private String tip_doc;

    @JsonProperty("institucion")
    private String institucion;

    @JsonProperty("participo")
    private String participo;

    @JsonProperty("nom_grupo")
    private String nom_grupo;

    @JsonProperty("carrera")
    private String carrera;

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("ciudad")
    private String ciudad;

    @JsonProperty("email")
    private String email;

    @JsonProperty("num_orden")
    private String num_orden;

    @JsonProperty("carne")
    private Long carne;

    @JsonProperty("tipo_partic")
    private String tipo_partic;


    @JsonProperty("grado")
    private String grado;

    @JsonProperty("codigo_area")
    private String codigo_area;

   @JsonProperty("pago")
    private Integer pago;
  
  
    public Integer getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(Integer id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public Integer getId_concurso() {
        return id_concurso;
    }

    public void setId_concurso(Integer id_concurso) {
        this.id_concurso = id_concurso;
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

    public String getTip_doc() {
        return tip_doc;
    }

    public void setTip_doc(String tip_doc) {
        this.tip_doc = tip_doc;
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

    public String getNom_grupo() {
        return nom_grupo;
    }

    public void setNom_grupo(String nom_grupo) {
        this.nom_grupo = nom_grupo;
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

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public Long getCarne() {
        return carne;
    }

    public void setCarne(Long carne) {
        this.carne = carne;
    }

    public String getTipo_partic() {
        return tipo_partic;
    }

    public void setTipo_partic(String tipo_partic) {
        this.tipo_partic = tipo_partic;
    }

    

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getCodigo_area() {
        return codigo_area;
    }

    public void setCodigo_area(String codigo_area) {
        this.codigo_area = codigo_area;
    }

      public Integer getpago() {
        return pago;
    }

    public void setpago(Integer pago) {
        this.pago = pago;
    }
   
    
    public InscritoDTO() {
    }

}
