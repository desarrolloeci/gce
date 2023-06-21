package com.escuela.gce.service.impl;

import java.util.List;
import java.util.Map;

import com.escuela.gce.db.dao.IConcursoDAO;
import com.escuela.gce.db.dao.impl.ConcursoDAOImpl;
import com.escuela.gce.enums.EEstadoConcurso;
import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.ConcursoDTO;
import com.escuela.gce.model.dto.ConcursoDesplegableDTO;
import com.escuela.gce.model.mapper.ConcursoMapper;
import com.escuela.gce.model.mapper.ConcursoMapperImpl;
import com.escuela.gce.model.persistence.ConcursoEntity;
import com.escuela.gce.service.IConcursoService;
import javax.ejb.Stateless;

@Stateless
public class ConcursoService implements IConcursoService {

    public ConcursoService() {
        this.dao = new ConcursoDAOImpl();
        this.mapper = new ConcursoMapperImpl();
    }

    private final IConcursoDAO dao;

    private final ConcursoMapper mapper;

    @Override
    public Long contar() throws ModelException {
        try {
            return dao.contar();
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public ConcursoDTO consultarPorId(int id) throws ModelException {
        try {
            return mapper.toConcursoDto(dao.consultarPorId(id));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public List<ConcursoDTO> consultarPorFiltros(ConcursoDTO concurso, Map<String, String> params)
            throws ModelException {
        try {
            return mapper.map(dao.consultarPorFiltros(mapper.toConcursoEntity(concurso), params));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public ConcursoDTO crear(ConcursoDTO concurso) throws ModelException {
        try {
            return mapper.toConcursoDto(dao.crear(mapper.toConcursoEntity(concurso)));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public ConcursoDTO modificar(ConcursoDTO concurso) throws ModelException {
        try {
            return mapper.toConcursoDto(dao.modificar(mapper.toConcursoEntity(concurso)));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public ConcursoDTO inactivar(int id) throws ModelException {
        try {
            ConcursoEntity concurso = dao.consultarPorId(id);
            concurso.setActivo(EEstadoConcurso.INACTIVO.getCode().charAt(0));
            return mapper.toConcursoDto(dao.modificar(concurso));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public List<ConcursoDesplegableDTO> allConcursos()throws ModelException {
        try {
            return mapper.mapAllConcursos(dao.allConcursos());
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }}

}
