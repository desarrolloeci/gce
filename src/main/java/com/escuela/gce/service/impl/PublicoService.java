package com.escuela.gce.service.impl;

import java.util.List;
import java.util.Map;

import com.escuela.gce.db.dao.IPublicoDAO;
import com.escuela.gce.db.dao.impl.PublicoDAOImpl;
import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.PublicoDTO;
import com.escuela.gce.model.mapper.PublicoMapper;
import com.escuela.gce.model.mapper.PublicoMapperImpl;
import com.escuela.gce.service.IPublicoService;
import javax.ejb.Stateless;

@Stateless
public class PublicoService implements IPublicoService {

    public PublicoService() {
        this.dao = new PublicoDAOImpl();
        this.mapper = new PublicoMapperImpl();

    }

    private final IPublicoDAO dao;

    private final PublicoMapper mapper;

    @Override
    public PublicoDTO consultarPorId(int id) throws ModelException {
        try {
            return mapper.toPublicoDto(dao.consultarPorId(id));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public List<PublicoDTO> consultarPorFiltros(PublicoDTO publico, Map<String, String> params)
            throws ModelException {
        try {
            return mapper.map(dao.consultarPorFiltros(mapper.toPublicoEntity(publico), params));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }
}
