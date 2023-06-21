package com.escuela.gce.model.mapper;

import com.escuela.gce.model.dto.ConcursoDTO;
import com.escuela.gce.model.dto.ConcursoDesplegableDTO;
import com.escuela.gce.model.persistence.ConcursoEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcursoMapperImpl implements ConcursoMapper {

    @Override
    public ConcursoDTO toConcursoDto(ConcursoEntity concurso) {
        if (concurso == null) {
            return null;
        }

        ConcursoDTO concursoDTO = new ConcursoDTO();
        if (concurso.getActivo() != null) {
            concursoDTO.setActivo(concurso.getActivo());
        }
        concursoDTO.setFecha_limpago(concurso.getFechaLimPago()==null ? ""  :concurso.getFechaLimPago().toString());
        concursoDTO.setFecha_limpago1(concurso.getFechaLimPago1()==null ? "" :concurso.getFechaLimPago1().toString());
        concursoDTO.setId_concurso(concurso.getId());
        if (concurso.getIdEventoeci() != null) {
            concursoDTO.setId_eventoeci(concurso.getIdEventoeci());
        }
        if (concurso.getMaxEquipo() != null) {
            concursoDTO.setMax_equipo(concurso.getMaxEquipo());
        }
        if (concurso.getMinEquipo() != null) {
            concursoDTO.setMin_equipo(concurso.getMinEquipo());
        }
        concursoDTO.setNombre(concurso.getNombre());
        concursoDTO.setPeriodo(concurso.getPeriodo());
        concursoDTO.setPublico(concurso.getPublico());
        if (concurso.getTipo() != null) {
            concursoDTO.setTipo(concurso.getTipo());
        }
        if (concurso.getIs_pago() != null) {
            concursoDTO.setIs_pago(concurso.getIs_pago());
        }
        if (concurso.getTipoConcurso() != null) {
            concursoDTO.setTipo_concurso(concurso.getTipoConcurso());
        }
        concursoDTO.setValor(concurso.getValor());
        if (concurso.getValorTotal() != null) {
            concursoDTO.setValor_total(concurso.getValorTotal());
        }
        if (concurso.getValorTotalExt() != null) {
            concursoDTO.setValor_total_ext(concurso.getValorTotalExt());
        }

        return concursoDTO;
    }

    @Override
    public ConcursoEntity toConcursoEntity(ConcursoDTO concurso) {
        if (concurso == null) {
            return null;
        }

        ConcursoEntity concursoEntity = new ConcursoEntity();

        concursoEntity.setActivo(concurso.getActivo());
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed;
        try {
            parsed = formato.parse(concurso.getFecha_limpago());
            concursoEntity.setFechaLimPago(new java.sql.Date(parsed.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(ConcursoMapperImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date parsedIni;
        
        try {
            parsedIni = formato.parse(concurso.getFecha_limpago1());
            concursoEntity.setFechaLimPago1(new java.sql.Date(parsedIni.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(ConcursoMapperImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        concursoEntity.setId(concurso.getId_concurso());
        concursoEntity.setIdEventoeci(concurso.getId_eventoeci());
        concursoEntity.setMaxEquipo(concurso.getMax_equipo());
        concursoEntity.setMinEquipo(concurso.getMin_equipo());
        concursoEntity.setNombre(concurso.getNombre());
        concursoEntity.setPeriodo(concurso.getPeriodo());
        concursoEntity.setPublico(concurso.getPublico());
        concursoEntity.setTipo(concurso.getTipo());
        concursoEntity.setIs_pago(concurso.getIs_pago());
        concursoEntity.setTipoConcurso(concurso.getTipo_concurso());
        concursoEntity.setValor(concurso.getValor());
        concursoEntity.setValorTotal(concurso.getValor_total());
        concursoEntity.setValorTotalExt(concurso.getValor_total_ext());

        return concursoEntity;
    }

    @Override
    public List<ConcursoDTO> map(List<ConcursoEntity> concursos) {
        if (concursos == null) {
            return null;
        }

        List<ConcursoDTO> list = new ArrayList<ConcursoDTO>(concursos.size());
        for (ConcursoEntity concursoEntity : concursos) {
            list.add(toConcursoDto(concursoEntity));
        }

        return list;
    }
    
    @Override
    public List<ConcursoDesplegableDTO> mapAllConcursos(List<ConcursoEntity> concursos) {
        if (concursos == null) {
            return null;
        }

        List<ConcursoDesplegableDTO> list = new ArrayList<ConcursoDesplegableDTO>(concursos.size());
        ConcursoDesplegableDTO concursoDTO;
        
        for (int i = 0; i < concursos.size(); i++) {
             concursoDTO=new ConcursoDesplegableDTO();
            concursoDTO.setIdConcurso(concursos.get(i).getId());
            concursoDTO.setNombre(concursos.get(i).getNombre());
            list.add(concursoDTO);
        }
        

        return list;
    }
}
