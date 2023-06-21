package com.escuela.gce.db.dao;

import java.util.List;
import java.util.Map;


import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.persistence.EventoEntity;

public interface IEventoDAO {

	Long contar() throws ModelException;

	EventoEntity consultarPorId(int id) throws ModelException;

	List<EventoEntity> consultarPorFiltros(EventoEntity evento, Map<String, String> params) throws ModelException;

	EventoEntity crear(EventoEntity evento) throws ModelException;

	EventoEntity modificar(EventoEntity evento) throws ModelException;

}
