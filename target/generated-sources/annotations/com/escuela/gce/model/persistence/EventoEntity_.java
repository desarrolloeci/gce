package com.escuela.gce.model.persistence;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.5.v20191016-rNA", date="2022-12-20T09:57:24")
@StaticMetamodel(EventoEntity.class)
public class EventoEntity_ { 

    public static volatile SingularAttribute<EventoEntity, String> periodo;
    public static volatile SingularAttribute<EventoEntity, Date> fechaInicio;
    public static volatile SingularAttribute<EventoEntity, Integer> id;
    public static volatile SingularAttribute<EventoEntity, String> nombre;
    public static volatile SingularAttribute<EventoEntity, Date> fechaFin;
    public static volatile SingularAttribute<EventoEntity, Character> activo;

}