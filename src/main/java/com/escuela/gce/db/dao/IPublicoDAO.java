package com.escuela.gce.db.dao;

import java.util.List;
import java.util.Map;


import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.persistence.PublicoEntity;

public interface IPublicoDAO {

	PublicoEntity consultarPorId(int id) throws ModelException;

	List<PublicoEntity> consultarPorFiltros(PublicoEntity publico, Map<String, String> params) throws ModelException;

}
