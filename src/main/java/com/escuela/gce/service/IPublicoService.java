package com.escuela.gce.service;

import java.util.List;
import java.util.Map;


import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.PublicoDTO;

public interface IPublicoService {

	PublicoDTO consultarPorId(int id) throws ModelException;

	List<PublicoDTO> consultarPorFiltros(PublicoDTO publico, Map<String, String> params) throws ModelException;

}
