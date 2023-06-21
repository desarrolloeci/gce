package com.escuela.gce.service.impl;

import com.escuela.gce.db.dao.IAsistenciaDAO;
import java.util.List;
import java.util.Map;

import com.escuela.gce.db.dao.IInscritoDAO;
import com.escuela.gce.db.dao.impl.AsistenciaDAOImpl;
import com.escuela.gce.db.dao.impl.InscritoDAOImpl;
import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.AsistenciaDTO;
import com.escuela.gce.model.dto.AsistenciaMapperDTO;
import com.escuela.gce.model.dto.InscritoDTO;
import com.escuela.gce.model.mapper.InscritoMapper;
import com.escuela.gce.model.mapper.InscritoMapperImpl;
import com.escuela.gce.model.persistence.AsistenciaEntity;
import com.escuela.gce.model.persistence.InscritoEntity;
import com.escuela.gce.service.IAsistenciaService;
import com.escuela.gce.service.IInscritoService;
import javax.ejb.Stateless;

@Stateless
public class AsistenciaService implements IAsistenciaService {

    public AsistenciaService() {
        this.dao = new AsistenciaDAOImpl();
        this.mapper = new InscritoMapperImpl();
    }

    private final IAsistenciaDAO dao;

    private final InscritoMapper mapper;

    @Override
    public AsistenciaEntity consultarPorId(int id) throws ModelException {
        try {
            return dao.consultarPorId(id);
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public List<AsistenciaEntity> consultarAsistenciaExistente(AsistenciaEntity asistenciaEntity) throws ModelException {
        try {
            return dao.consultarAsistenciaExistente(asistenciaEntity);
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public AsistenciaEntity crear(AsistenciaEntity nuevo) throws ModelException {
        try {
            return dao.crear(nuevo);
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public List<AsistenciaMapperDTO> consultarListadoAsistencia(Integer i) throws ModelException {
        try {
            return dao.consultarListadoAsistencia(i);
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    
}
