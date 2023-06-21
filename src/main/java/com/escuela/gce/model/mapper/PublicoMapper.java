package com.escuela.gce.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.escuela.gce.model.dto.PublicoDTO;
import com.escuela.gce.model.persistence.PublicoEntity;

@Mapper(componentModel = "spring")
public interface PublicoMapper {

	PublicoDTO toPublicoDto(PublicoEntity publico);

	PublicoEntity toPublicoEntity(PublicoDTO publico);

	List<PublicoDTO> map(List<PublicoEntity> publicos);

}