package com.escuela.gce.db.dao;

import java.util.List;
import java.util.Map;


import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.persistence.ConcursoEntity;

public interface IConcursoDAO {

	Long contar();

	ConcursoEntity consultarPorId(int id) throws ModelException;

	List<ConcursoEntity> consultarPorFiltros(ConcursoEntity concurso, Map<String, String> params) throws ModelException;

	ConcursoEntity crear(ConcursoEntity concurso) throws ModelException;

	ConcursoEntity modificar(ConcursoEntity concurso) throws ModelException;

        List<ConcursoEntity> allConcursos()throws ModelException;;

}
