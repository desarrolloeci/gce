package com.escuela.gce.model.mapper;

import com.escuela.gce.model.dto.PublicoDTO;
import com.escuela.gce.model.persistence.PublicoEntity;
import java.util.ArrayList;
import java.util.List;

public class PublicoMapperImpl implements PublicoMapper {

    @Override
    public PublicoDTO toPublicoDto(PublicoEntity publico) {
        if (publico == null) {
            return null;
        }

        PublicoDTO publicoDTO = new PublicoDTO();

        publicoDTO.setId_publico(publico.getId());
        publicoDTO.setNombre(publico.getNombre());

        return publicoDTO;
    }

    @Override
    public PublicoEntity toPublicoEntity(PublicoDTO publico) {
        if (publico == null) {
            return null;
        }

        PublicoEntity publicoEntity = new PublicoEntity();

        publicoEntity.setId(publico.getId_publico());
        publicoEntity.setNombre(publico.getNombre());

        return publicoEntity;
    }

    @Override
    public List<PublicoDTO> map(List<PublicoEntity> publicos) {
        if (publicos == null) {
            return null;
        }

        List<PublicoDTO> list = new ArrayList<PublicoDTO>(publicos.size());
        for (PublicoEntity publicoEntity : publicos) {
            list.add(toPublicoDto(publicoEntity));
        }

        return list;
    }
}
