package com.escuela.gce.service;

import java.util.List;
import java.util.Map;


import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.EventoDTO;

public interface IEventoService {

	Long contar() throws ModelException;

	EventoDTO consultarPorId(int id) throws ModelException;

	List<EventoDTO> consultarPorFiltros(EventoDTO evento, Map<String, String> params) throws ModelException;

	EventoDTO crear(EventoDTO evento) throws ModelException;

	EventoDTO modificar(EventoDTO evento) throws ModelException;

	EventoDTO inactivar(int id) throws ModelException;

}
