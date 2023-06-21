/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.gce.db.dao;

import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.persistence.PersonaActivaEntity;
import java.util.List;

/**
 *
 * @author desarrollador3
 */
public interface IPersonaActivaDAO {

    List<PersonaActivaEntity> consultarPorEmail(String email) throws ModelException;

    List<PersonaActivaEntity> consultarPorRol(String rol) throws ModelException;
}
