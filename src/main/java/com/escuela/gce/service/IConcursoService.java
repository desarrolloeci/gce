package com.escuela.gce.service;

import java.util.List;
import java.util.Map;


import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.dto.ConcursoDTO;
import com.escuela.gce.model.dto.ConcursoDesplegableDTO;

public interface IConcursoService {

	Long contar() throws ModelException;

	ConcursoDTO consultarPorId(int id) throws ModelException;

	List<ConcursoDTO> consultarPorFiltros(ConcursoDTO concurso, Map<String, String> params) throws ModelException;

	ConcursoDTO crear(ConcursoDTO concurso) throws ModelException;

	ConcursoDTO modificar(ConcursoDTO concurso) throws ModelException;

	ConcursoDTO inactivar(int id) throws ModelException;

        List<ConcursoDesplegableDTO> allConcursos() throws ModelException;

}
