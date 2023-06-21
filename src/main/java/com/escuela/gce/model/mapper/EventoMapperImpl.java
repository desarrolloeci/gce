package com.escuela.gce.model.mapper;

import com.escuela.gce.model.dto.EventoDTO;
import com.escuela.gce.model.persistence.EventoEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoMapperImpl implements EventoMapper {

    @Override
    public EventoDTO toEventoDto(EventoEntity evento) {
        if (evento == null) {
            return null;
        }

        EventoDTO eventoDTO = new EventoDTO();

        eventoDTO.setActivo(evento.getActivo());
        eventoDTO.setFecha_fin(evento.getFechaFin().toString());
        eventoDTO.setFecha_inicio(evento.getFechaInicio().toString());
        eventoDTO.setId_evento(evento.getId());
        eventoDTO.setNombre(evento.getNombre());
        eventoDTO.setPeriodo(evento.getPeriodo());

        return eventoDTO;
    }

    @Override
    public EventoEntity toEventoEntity(EventoDTO evento) {
        if (evento == null) {
            return null;
        }

        EventoEntity eventoEntity = new EventoEntity();

        eventoEntity.setActivo(evento.getActivo());
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed;
        try {
            parsed = formato.parse(evento.getFecha_fin());
            eventoEntity.setFechaFin(new java.sql.Date(parsed.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(EventoMapperImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Date parsedIni;
        try {
            parsedIni = formato.parse(evento.getFecha_inicio());
            eventoEntity.setFechaInicio(new java.sql.Date(parsedIni.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(EventoMapperImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        eventoEntity.setId(evento.getId_evento());
        eventoEntity.setNombre(evento.getNombre());
        eventoEntity.setPeriodo(evento.getPeriodo());

        return eventoEntity;
    }

    @Override
    public List<EventoDTO> map(List<EventoEntity> eventos) {
        if (eventos == null) {
            return null;
        }

        List<EventoDTO> list = new ArrayList<EventoDTO>(eventos.size());
        for (EventoEntity eventoEntity : eventos) {
            list.add(toEventoDto(eventoEntity));
        }

        return list;
    }
}
