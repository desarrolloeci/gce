package com.escuela.gce.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.escuela.gce.model.dto.ConcursoDTO;
import com.escuela.gce.model.dto.ConcursoDesplegableDTO;
import com.escuela.gce.model.persistence.ConcursoEntity;

@Mapper(componentModel = "spring")
public interface ConcursoMapper {

    ConcursoDTO toConcursoDto(ConcursoEntity concurso);

    ConcursoEntity toConcursoEntity(ConcursoDTO concurso);

    List<ConcursoDTO> map(List<ConcursoEntity> concursos);

    List<ConcursoDesplegableDTO> mapAllConcursos(List<ConcursoEntity> concursos); 
}
