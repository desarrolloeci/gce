package com.escuela.gce.db.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;

import com.escuela.gce.db.dao.AbstractDAO;
import com.escuela.gce.db.dao.IEventoDAO;
import com.escuela.gce.helper.constants.ConstantsFields;
import com.escuela.gce.model.persistence.EventoEntity;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class EventoDAOImpl extends AbstractDAO<EventoEntity> implements IEventoDAO {

    public EntityManagerFactory emf;

    public EntityManager em;

    public EventoDAOImpl() {
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
        StringBuilder jpql = new StringBuilder("SELECT t FROM EventoEntity t WHERE 1 = 1 ");
        // Q. Order By
        jpql.append(" ORDER BY t.id");
        // END QUERY

        TypedQuery<EventoEntity> query = em.createQuery(jpql.toString(), EventoEntity.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }

        return (long) query.getResultList().size();
    }

    @Override
    public EventoEntity consultarPorId(int id) {
        return super.findOne(id, EventoEntity.class);
    }

    @Override
    public List<EventoEntity> consultarPorFiltros(EventoEntity filtroEvento, Map<String, String> params) {
        // PARAMETROS
        Map<String, Object> parameters = new HashMap<>();

        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT t FROM EventoEntity t WHERE 1 = 1 AND t.activo = 'S' ");
        // WHERE
        if (filtroEvento.getId() > 0) {
            jpql.append(" AND t.id = :ID ");
            parameters.put("ID", filtroEvento.getId());
        }
        if (!StringUtils.isBlank(filtroEvento.getNombre())) {
            jpql.append(" AND UPPER(t.nombre) LIKE :NOMBRE ");
            parameters.put("NOMBRE", ConstantsFields.COMODIN_BD
                    + filtroEvento.getNombre().toUpperCase() + ConstantsFields.COMODIN_BD);
        }
        // Q. Order By
        jpql.append(" ORDER BY t.id DESC");
        // END QUERY

        TypedQuery<EventoEntity> query = em.createQuery(jpql.toString(), EventoEntity.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }

        return query.getResultList();
    }

    
    @Override
    public EventoEntity crear(EventoEntity evento) {
        evento.setId(super.maxID("EventoEntity")+1);
        super.create(evento);
        return evento;
    }

    @Transactional
    @Override
    public EventoEntity modificar(EventoEntity evento) {
        super.update(evento);
        return evento;
    }
}
