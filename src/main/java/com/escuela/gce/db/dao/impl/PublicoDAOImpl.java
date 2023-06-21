package com.escuela.gce.db.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import com.escuela.gce.db.dao.AbstractDAO;
import com.escuela.gce.db.dao.IPublicoDAO;
import com.escuela.gce.helper.constants.ConstantsFields;
import com.escuela.gce.model.persistence.PublicoEntity;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class PublicoDAOImpl extends AbstractDAO<PublicoEntity> implements IPublicoDAO {

    public EntityManagerFactory emf;

    public EntityManager em;

    public PublicoDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("Registro");
        this.em = emf.createEntityManager();
    }

    @PreDestroy
    public void destruct() {
        emf.close();
    }

    @Override
    public PublicoEntity consultarPorId(int id) {
        return super.findOne(id, PublicoEntity.class);
    }

    @Override
    public List<PublicoEntity> consultarPorFiltros(PublicoEntity filtroPublico, Map<String, String> params) {
        // PARAMETROS
        Map<String, Object> parameters = new HashMap<>();

        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT t FROM PublicoEntity t WHERE 1 = 1 ");
        // WHERE
        if (filtroPublico.getId() > 0) {
            jpql.append(" AND t.id = :ID ");
            parameters.put("ID", filtroPublico.getId());
        }
        if (!StringUtils.isBlank(filtroPublico.getNombre())) {
            jpql.append(" AND UPPER(t.nombre) LIKE :NOMBRE ");
            parameters.put("NOMBRE", ConstantsFields.COMODIN_BD
                    + filtroPublico.getNombre().toUpperCase() + ConstantsFields.COMODIN_BD);
        }
        // Q. Order By
        jpql.append(" ORDER BY t.id DESC");
        // END QUERY

        TypedQuery<PublicoEntity> query = em.createQuery(jpql.toString(), PublicoEntity.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }

        return query.getResultList();
    }
}
