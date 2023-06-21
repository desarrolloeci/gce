/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.gce.service.impl;

import com.escuela.gce.db.dao.IPersonaActivaDAO;
import com.escuela.gce.db.dao.impl.PersonaActivoDAOImpl;
import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.PersonaActivoDTO;
import com.escuela.gce.model.mapper.PersonaActivaMapper;
import com.escuela.gce.model.mapper.PersonaActivaMapperImpl;
import com.escuela.gce.model.persistence.PersonaActivaEntity;
import com.escuela.gce.service.IPersonaActivaService;
import java.util.List;

/**
 *
 * @author desarrollador3
 */
public class PersonaActivaService implements IPersonaActivaService{

    public PersonaActivaService() {
        this.dao = new PersonaActivoDAOImpl();
        this.mapper = new PersonaActivaMapperImpl();
    }

    private final IPersonaActivaDAO dao;

    private final PersonaActivaMapper mapper;
    
    
    @Override
    public List<PersonaActivoDTO> consultarPorEmail(String email) throws ModelException {
        
        try {
            return mapper.map(dao.consultarPorEmail(email));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
        
    }
    
    @Override
    public List<PersonaActivoDTO> consultarPorRol(String rol) throws ModelException {
        
        try {
            return mapper.map(dao.consultarPorRol(rol));
        } catch (Exception excepcion) {
            throw new ModelException(excepcion.getMessage());
        }
        
    }
    
    
    
}
