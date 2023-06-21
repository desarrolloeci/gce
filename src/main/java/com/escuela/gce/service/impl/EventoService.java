package com.escuela.gce.service.impl;

import java.util.List;
import java.util.Map;

import com.escuela.gce.db.dao.IEventoDAO;
import com.escuela.gce.db.dao.impl.EventoDAOImpl;
import com.escuela.gce.enums.EEstadoConcurso;
import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.EventoDTO;
import com.escuela.gce.model.mapper.EventoMapper;
import com.escuela.gce.model.mapper.EventoMapperImpl;
import com.escuela.gce.model.persistence.EventoEntity;
import com.escuela.gce.service.IEventoService;
import javax.ejb.Stateless;

@Stateless
public class EventoService implements IEventoService {

    public EventoService() {
        this.dao = new EventoDAOImpl();
        this.mapper = new EventoMapperImpl();
    }

    private final IEventoDAO dao;

    private final EventoMapper mapper;

    @Override
    public Long contar() throws ModelException {
        try {
            return dao.contar();
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public EventoDTO consultarPorId(int id) throws ModelException {
        try {
            return mapper.toEventoDto(dao.consultarPorId(id));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public List<EventoDTO> consultarPorFiltros(EventoDTO evento, Map<String, String> params) throws ModelException {
        try {
            return mapper.map(dao.consultarPorFiltros(mapper.toEventoEntity(evento), params));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public EventoDTO crear(EventoDTO evento) throws ModelException {
        try {
            return mapper.toEventoDto(dao.crear(mapper.toEventoEntity(evento)));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public EventoDTO modificar(EventoDTO evento) throws ModelException {
        try {
            return mapper.toEventoDto(dao.modificar(mapper.toEventoEntity(evento)));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

    @Override
    public EventoDTO inactivar(int id) throws ModelException {
        try {
            EventoEntity evento = dao.consultarPorId(id);
            evento.setActivo(EEstadoConcurso.INACTIVO.getCode().charAt(0));
            return mapper.toEventoDto(dao.modificar(evento));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
    }

}
