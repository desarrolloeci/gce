package com.escuela.gce.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.escuela.gce.model.dto.EventoDTO;
import com.escuela.gce.model.persistence.EventoEntity;

@Mapper(componentModel = "spring")
public interface EventoMapper {

	EventoDTO toEventoDto(EventoEntity evento);

	EventoEntity toEventoEntity(EventoDTO evento);

	List<EventoDTO> map(List<EventoEntity> eventos);

}