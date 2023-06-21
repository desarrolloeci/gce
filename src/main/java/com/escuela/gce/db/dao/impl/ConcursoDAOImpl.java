package com.escuela.gce.db.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;

import com.escuela.gce.db.dao.AbstractDAO;
import com.escuela.gce.db.dao.IConcursoDAO;
import com.escuela.gce.exception.ModelException;
import com.escuela.gce.helper.constants.ConstantsFields;
import com.escuela.gce.model.persistence.ConcursoEntity;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class ConcursoDAOImpl extends AbstractDAO<ConcursoEntity> implements IConcursoDAO {

    public EntityManagerFactory emf;

    public EntityManager em;

    public ConcursoDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("Registro");
        this.em = emf.createEntityManager();
    }

    @PreDestroy
    public void destruct() {
        emf.close();
    }

    @Override
    public Long contar() {
        // PARAMETROS
        Map<String, Object> parameters = new HashMap<>();

        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT t FROM ConcursoEntity t WHERE 1 = 1 AND t.activo = 'S' ");
        // Q. Order By
        jpql.append(" ORDER BY t.id");
        // END QUERY

        TypedQuery<ConcursoEntity> query = em.createQuery(jpql.toString(), ConcursoEntity.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }

        return (long) query.getResultList().size();
    }

    @Override
    public ConcursoEntity consultarPorId(int id) {
        return em.find(ConcursoEntity.class, id);
    }

    @Override
    public List<ConcursoEntity> consultarPorFiltros(ConcursoEntity filtroConcurso, Map<String, String> params) {
        // PARAMETROS
        Map<String, Object> parameters = new HashMap<>();

        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT distinct t FROM ConcursoEntity t WHERE 1 = 1 ");
        // WHERE
        if (filtroConcurso.getId() > 0) {
            jpql.append(" AND t.id = :ID ");
            parameters.put("ID", filtroConcurso.getId());
        }
        if (!StringUtils.isBlank(filtroConcurso.getNombre())) {
            jpql.append(" AND UPPER(t.nombre) LIKE :NOMBRE ");
            parameters.put("NOMBRE", ConstantsFields.COMODIN_BD
                    + filtroConcurso.getNombre().toUpperCase() + ConstantsFields.COMODIN_BD);
        }
        // Q. Order By
        jpql.append(" ORDER BY t.id DESC");
        // END QUERY

        TypedQuery<ConcursoEntity> query = em.createQuery(jpql.toString(), ConcursoEntity.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }

        return query.getResultList();
    }

    @Transactional
    @Override
    public ConcursoEntity crear(ConcursoEntity concurso) {
        concurso.setId(super.maxID("ConcursoEntity")+1);
        super.create(concurso);
        return concurso;
    }

    @Transactional
    @Override
    public ConcursoEntity modificar(ConcursoEntity concurso) {
        super.update(concurso);
        return concurso;
    }

    @Override
    public List<ConcursoEntity> allConcursos() throws ModelException {
       
        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT distinct t FROM ConcursoEntity t WHERE 1 = 1 ");
        // Q. Order By
        jpql.append(" ORDER BY t.id DESC");
        // END QUERY

        TypedQuery<ConcursoEntity> query = em.createQuery(jpql.toString(), ConcursoEntity.class);
        

        return query.getResultList();
    }

}
