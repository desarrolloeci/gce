package com.escuela.gce.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.escuela.gce.model.dto.InscritoDTO;
import com.escuela.gce.model.persistence.InscritoEntity;

@Mapper(componentModel = "spring")
public interface InscritoMapper {

	InscritoDTO toInscritoDto(InscritoEntity inscrito);

	InscritoEntity toInscritoEntity(InscritoDTO inscrito);

	List<InscritoDTO> map(List<InscritoEntity> inscritos);

}