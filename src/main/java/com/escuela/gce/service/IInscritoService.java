package com.escuela.gce.service;

import java.util.List;
import java.util.Map;


import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.InscritoDTO;

public interface IInscritoService {

	InscritoDTO consultarPorId(int id) throws ModelException;

	List<InscritoDTO> consultarPorFiltros(InscritoDTO inscrito, Map<String, String> params) throws ModelException;

        List<InscritoDTO> consultarPorConcursoCedula(int id_concurso, String cedula)throws ModelException;

}
