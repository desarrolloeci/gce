package com.escuela.gce.db.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import com.escuela.gce.db.dao.AbstractDAO;
import com.escuela.gce.db.dao.IInscritoDAO;
import com.escuela.gce.exception.ModelException;
import com.escuela.gce.helper.constants.ConstantsFields;
import com.escuela.gce.model.persistence.InscritoEntity;
import java.util.ArrayList;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class InscritoDAOImpl extends AbstractDAO<InscritoEntity> implements IInscritoDAO {

    public EntityManagerFactory emf;

    public EntityManager em;

    public InscritoDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("Registro");
        this.em = emf.createEntityManager();
    }

    @PreDestroy
    public void destruct() {
        emf.close();
    }

    @Override
    public InscritoEntity consultarPorId(int id) {
        return super.findOne(id, InscritoEntity.class);
    }

    @Override
    public List<InscritoEntity> consultarPorFiltros(InscritoEntity filtroInscrito, Map<String, String> params) {
        // PARAMETROS
        Map<String, Object> parameters = new HashMap<>();

        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT t FROM InscritoEntity t WHERE 1 = 1 ");
        // WHERE
        
        if (filtroInscrito.getIdConcurso() > 0) {
            jpql.append(" AND t.idConcurso = :ID_CONCURSO ");
            parameters.put("ID_CONCURSO", filtroInscrito.getIdConcurso());
        }
        if (!StringUtils.isBlank(filtroInscrito.getNombres())) {
            jpql.append(" AND UPPER(t.nombre) LIKE :NOMBRE ");
            parameters.put("NOMBRE", ConstantsFields.COMODIN_BD
                    + filtroInscrito.getNombres().toUpperCase() + ConstantsFields.COMODIN_BD);
        }
        // Q. Order By
        jpql.append(" ORDER BY t.id DESC");
        // END QUERY

        TypedQuery<InscritoEntity> query = em.createQuery(jpql.toString(), InscritoEntity.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }
        
        List<InscritoEntity> list = query.getResultList();
        
        return  list;
    }

    @Override
    public List<InscritoEntity> consultarPorConcursoCedula(int idConcurso, String cedula) throws ModelException {
        Map<String, Object> parameters = new HashMap<>();

        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT t FROM InscritoEntity t WHERE 1 = 1 ");
        // WHERE
        
        if (idConcurso > 0) {
            jpql.append(" AND t.idConcurso = :ID_CONCURSO ");
            parameters.put("ID_CONCURSO", idConcurso);
        }
        if (idConcurso > 0) {
            jpql.append(" AND t.docum = :DOCUM ");
            parameters.put("DOCUM", cedula);
        }
        // Q. Order By
        jpql.append(" ORDER BY t.id DESC");
        // END QUERY

        TypedQuery<InscritoEntity> query = em.createQuery(jpql.toString(), InscritoEntity.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }
       
        List<InscritoEntity> list = query.getResultList();
        

        return  list;
    }
}
