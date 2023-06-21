/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.gce.db.dao.impl;

import com.escuela.gce.db.dao.AbstractDAO;
import com.escuela.gce.db.dao.IPersonaActivaDAO;
import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.persistence.InscritoEntity;
import com.escuela.gce.model.persistence.PersonaActivaEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author desarrollador3
 */
@Stateless
public class PersonaActivoDAOImpl extends AbstractDAO<PersonaActivaEntity> implements IPersonaActivaDAO {

    public EntityManagerFactory emf;

    public EntityManager em;

    public PersonaActivoDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("Registro");
        this.em = emf.createEntityManager();
    }

    @PreDestroy
    public void destruct() {
        emf.close();
    }

    @Override
    public List<PersonaActivaEntity> consultarPorEmail(String email) throws ModelException {
       
        // PARAMETROS
        Map<String, Object> parameters = new HashMap<>();

        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT t FROM PersonaActivaEntity t WHERE 1 = 1 ");
        
        if(email!= "") {
            jpql.append(" AND t.email = :EMAIL ");
            parameters.put("EMAIL", email);
        }
        TypedQuery<PersonaActivaEntity> query = em.createQuery(jpql.toString(), PersonaActivaEntity.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }
        
        List<PersonaActivaEntity> list = query.getResultList();
        
        return list;
        
    }
    
    @Override
    public List<PersonaActivaEntity> consultarPorRol(String rol) throws ModelException {
       
        // PARAMETROS
        Map<String, Object> parameters = new HashMap<>();

        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT t FROM PersonaActivaEntity t WHERE 1 = 1 ");
        
        if(rol!= "") {
            jpql.append(" AND t.tipo_rol = :ROL ");
            parameters.put("ROL", rol);
        }
        TypedQuery<PersonaActivaEntity> query = em.createQuery(jpql.toString(), PersonaActivaEntity.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }
        
        List<PersonaActivaEntity> list = query.getResultList();
        
        return list;
        
    }
    
}
