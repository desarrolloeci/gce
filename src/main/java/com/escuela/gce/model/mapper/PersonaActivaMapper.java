/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.gce.model.mapper;

import com.escuela.gce.model.dto.PersonaActivoDTO;
import com.escuela.gce.model.persistence.PersonaActivaEntity;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author desarrollador3
 */
@Mapper(componentModel = "spring")
public interface PersonaActivaMapper {

    PersonaActivoDTO toPersonaActivaDto(PersonaActivaEntity persona);

    PersonaActivaEntity toPersonaActivaEntity(PersonaActivoDTO persona);

    List<PersonaActivoDTO> map(List<PersonaActivaEntity> personas);
}
