package com.escuela.gce.service;

import java.util.List;
import java.util.Map;

import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.AsistenciaDTO;
import com.escuela.gce.model.dto.AsistenciaMapperDTO;
import com.escuela.gce.model.dto.InscritoDTO;
import com.escuela.gce.model.persistence.AsistenciaEntity;
import com.escuela.gce.model.persistence.InscritoEntity;

public interface IAsistenciaService {

    AsistenciaEntity consultarPorId(int id) throws ModelException;

    List<AsistenciaEntity> consultarAsistenciaExistente(AsistenciaEntity nuevo) throws ModelException;

    AsistenciaEntity crear(AsistenciaEntity nuevo) throws ModelException;

    List<AsistenciaMapperDTO> consultarListadoAsistencia(Integer id_concurso)throws ModelException;

}
