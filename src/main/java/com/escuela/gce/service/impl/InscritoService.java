package com.escuela.gce.service.impl;

import java.util.List;
import java.util.Map;

import com.escuela.gce.db.dao.IInscritoDAO;
import com.escuela.gce.db.dao.impl.InscritoDAOImpl;
import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.InscritoDTO;
import com.escuela.gce.model.mapper.InscritoMapper;
import com.escuela.gce.model.mapper.InscritoMapperImpl;
import com.escuela.gce.service.IInscritoService;
import javax.ejb.Stateless;

@Stateless
public class InscritoService implements IInscritoService {

    public InscritoService() {
        this.dao = new InscritoDAOImpl();
        this.mapper = new InscritoMapperImpl();
    }

    private final IInscritoDAO dao;

    private final InscritoMapper mapper;

    @Override
    public InscritoDTO consultarPorId(int id) throws ModelException {
        try {
            return mapper.toInscritoDto(dao.consultarPorId(id));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public List<InscritoDTO> consultarPorFiltros(InscritoDTO inscrito, Map<String, String> params)
            throws ModelException {
        try {
            return mapper.map(dao.consultarPorFiltros(mapper.toInscritoEntity(inscrito), params));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public List<InscritoDTO> consultarPorConcursoCedula(int idConcurso, String cedula) throws ModelException {
        try {
            return mapper.map(dao.consultarPorConcursoCedula(idConcurso,cedula));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }
}
