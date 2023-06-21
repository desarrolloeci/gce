package com.escuela.gce.db.dao;

import java.util.List;
import java.util.Map;


import com.escuela.gce.exception.ModelException;
import com.escuela.gce.model.persistence.InscritoEntity;

public interface IInscritoDAO {

	InscritoEntity consultarPorId(int id) throws ModelException;

	List<InscritoEntity> consultarPorFiltros(InscritoEntity inscrito, Map<String, String> params) throws ModelException;

        List<InscritoEntity> consultarPorConcursoCedula(int idConcurso, String cedula)throws ModelException;

}
