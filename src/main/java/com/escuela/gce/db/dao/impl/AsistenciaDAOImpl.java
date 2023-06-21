package com.escuela.gce.db.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import com.escuela.gce.db.dao.AbstractDAO;
import com.escuela.gce.db.dao.IAsistenciaDAO;
import com.escuela.gce.db.dao.IInscritoDAO;
import com.escuela.gce.exception.ModelException;
import com.escuela.gce.helper.constants.ConstantsFields;
import com.escuela.gce.model.dto.AsistenciaDTO;
import com.escuela.gce.model.dto.AsistenciaMapperDTO;
import com.escuela.gce.model.mapper.ConcursoMapperImpl;
import com.escuela.gce.model.persistence.AsistenciaEntity;
import com.escuela.gce.model.persistence.InscritoEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

@Stateless
public class AsistenciaDAOImpl extends AbstractDAO<AsistenciaEntity> implements IAsistenciaDAO {

    public EntityManagerFactory emf;

    public EntityManager em;

    public AsistenciaDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("Registro");
        this.em = emf.createEntityManager();
    }

    @PreDestroy
    public void destruct() {
        emf.close();
    }

    @Override
    public AsistenciaEntity consultarPorId(int id) {
        return super.findOne(id, AsistenciaEntity.class);
    }

//    @Override
//    public List<InscritoEntity> consultarPorFiltros(InscritoEntity filtroInscrito, Map<String, String> params) {
//        // PARAMETROS
//        Map<String, Object> parameters = new HashMap<>();
//
//        // QUERY
//        StringBuilder jpql = new StringBuilder("SELECT t FROM InscritoEntity t WHERE 1 = 1 ");
//        // WHERE
//        
//        if (filtroInscrito.getIdConcurso() > 0) {
//            jpql.append(" AND t.idConcurso = :ID_CONCURSO ");
//            parameters.put("ID_CONCURSO", filtroInscrito.getIdConcurso());
//        }
//        if (!StringUtils.isBlank(filtroInscrito.getNombres())) {
//            jpql.append(" AND UPPER(t.nombre) LIKE :NOMBRE ");
//            parameters.put("NOMBRE", ConstantsFields.COMODIN_BD
//                    + filtroInscrito.getNombres().toUpperCase() + ConstantsFields.COMODIN_BD);
//        }
//        // Q. Order By
//        jpql.append(" ORDER BY t.id DESC");
//        // END QUERY
//
//        TypedQuery<InscritoEntity> query = em.createQuery(jpql.toString(), InscritoEntity.class);
//        for (String param : parameters.keySet()) {
//            query.setParameter(param, parameters.get(param));
//        }
//       
//        List<InscritoEntity> list = query.getResultList();
//        
//
//        return  list;
//    }
//
//    @Override
//    public List<InscritoEntity> consultarPorConcursoCedula(int idConcurso, String cedula) throws ModelException {
//        Map<String, Object> parameters = new HashMap<>();
//
//        // QUERY
//        StringBuilder jpql = new StringBuilder("SELECT t FROM InscritoEntity t WHERE 1 = 1 ");
//        // WHERE
//        
//        if (idConcurso > 0) {
//            jpql.append(" AND t.idConcurso = :ID_CONCURSO ");
//            parameters.put("ID_CONCURSO", idConcurso);
//        }
//        if (idConcurso > 0) {
//            jpql.append(" AND t.docum = :DOCUM ");
//            parameters.put("DOCUM", cedula);
//        }
//        // Q. Order By
//        jpql.append(" ORDER BY t.id DESC");
//        // END QUERY
//
//        TypedQuery<InscritoEntity> query = em.createQuery(jpql.toString(), InscritoEntity.class);
//        for (String param : parameters.keySet()) {
//            query.setParameter(param, parameters.get(param));
//        }
//       
//        List<InscritoEntity> list = query.getResultList();
//        
//
//        return  list;
//    }
    @Override
    public List<AsistenciaEntity> consultarAsistenciaExistente(AsistenciaEntity ae) throws ModelException {
        Map<String, Object> parameters = new HashMap<>();

        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT t FROM AsistenciaEntity t WHERE t.fechaInicio = :FECHA ");
        // WHERE

        if (ae.getIdConcurso() > 0) {
            jpql.append(" AND t.idConcurso = :ID_CONCURSO ");
            parameters.put("ID_CONCURSO", ae.getIdConcurso());
        }
        if (!"".equals(ae.getIdParticipante())) {
            jpql.append(" AND t.idParticipante = :ID_PAR ");
            parameters.put("ID_PAR", ae.getIdParticipante());
        }
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed;
        try {
            String date = formato.format(new Date());
            parsed = formato.parse(date);
            parameters.put("FECHA",new java.sql.Date(parsed.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(ConcursoMapperImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        // Q. Order By
        jpql.append(" ORDER BY t.id DESC");
        // END QUERY

        TypedQuery<AsistenciaEntity> query = em.createQuery(jpql.toString(), AsistenciaEntity.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }

        List<AsistenciaEntity> list = query.getResultList();

        return list;
    }

    @Transactional
    @Override
    public AsistenciaEntity crear(AsistenciaEntity ae) throws ModelException {
        ae.setId(super.maxID("AsistenciaEntity") + 1);
        super.create(ae);
        return ae;
    }

    @Override
    public List<AsistenciaMapperDTO> consultarListadoAsistencia(Integer intgr) {
        Map<String, Object> parameters = new HashMap<>();

        // QUERY
        StringBuilder jpql = new StringBuilder("SELECT new com.escuela.gce.model.dto.AsistenciaMapperDTO"
                + "(t.id,i.nombres,i.apellido1 , t.fechaInicio ) FROM AsistenciaEntity t, InscritoEntity i "
                + " WHERE t.idParticipante=i.docum ");
        // WHERE
        if (intgr > 0) {
            jpql.append(" AND i.idConcurso = :ID_CONCURSO ");
            parameters.put("ID_CONCURSO", intgr);
        }

        // Q. Order By
        jpql.append(" ORDER BY t.id DESC");
        // END QUERY

        TypedQuery<AsistenciaMapperDTO> query = em.createQuery(jpql.toString(), AsistenciaMapperDTO.class);
        for (String param : parameters.keySet()) {
            query.setParameter(param, parameters.get(param));
        }
        
        
        List<AsistenciaMapperDTO> list=new ArrayList<>();
        list.addAll(query.getResultList());
        


//        
//        
//        List<AsistenciaMapperDTO> list2 =new ArrayList<AsistenciaMapperDTO>();
//        AsistenciaMapperDTO nuevo;
//        for (int i = 0; i < list.size(); i++) {
//            nuevo = new AsistenciaMapperDTO();
//            nuevo.setId(list.get(i).getId());
//            nuevo.setNombres(list.get(i).getNombres());
//            nuevo.setFecha_inicio(list.get(i).getFecha_inicio().toString());
//            list2.add(nuevo);
//        }

        return list;
    }
}
