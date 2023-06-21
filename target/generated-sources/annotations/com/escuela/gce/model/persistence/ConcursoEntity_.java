package com.escuela.gce.model.persistence;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.5.v20191016-rNA", date="2022-12-20T09:57:24")
@StaticMetamodel(ConcursoEntity.class)
public class ConcursoEntity_ { 

    public static volatile SingularAttribute<ConcursoEntity, Integer> idEventoeci;
    public static volatile SingularAttribute<ConcursoEntity, Character> tipo;
    public static volatile SingularAttribute<ConcursoEntity, String> periodo;
    public static volatile SingularAttribute<ConcursoEntity, Integer> minEquipo;
    public static volatile SingularAttribute<ConcursoEntity, Integer> valor;
    public static volatile SingularAttribute<ConcursoEntity, String> nombre;
    public static volatile SingularAttribute<ConcursoEntity, Integer> maxEquipo;
    public static volatile SingularAttribute<ConcursoEntity, Integer> valorTotalExt;
    public static volatile SingularAttribute<ConcursoEntity, Character> is_pago;
    public static volatile SingularAttribute<ConcursoEntity, Integer> tipoConcurso;
    public static volatile SingularAttribute<ConcursoEntity, Integer> valorTotal;
    public static volatile SingularAttribute<ConcursoEntity, Date> fechaLimPago;
    public static volatile SingularAttribute<ConcursoEntity, Date> fechaLimPago1;
    public static volatile SingularAttribute<ConcursoEntity, Integer> id;
    public static volatile SingularAttribute<ConcursoEntity, Integer> publico;
    public static volatile SingularAttribute<ConcursoEntity, Character> activo;

}