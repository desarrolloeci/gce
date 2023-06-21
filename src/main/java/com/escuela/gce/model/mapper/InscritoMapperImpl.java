package com.escuela.gce.model.mapper;

import com.escuela.gce.model.dto.InscritoDTO;
import com.escuela.gce.model.persistence.InscritoEntity;
import java.util.ArrayList;
import java.util.List;

public class InscritoMapperImpl implements InscritoMapper {

    @Override
    public InscritoDTO toInscritoDto(InscritoEntity inscrito) {
        if (inscrito == null) {
            return null;
        }

        InscritoDTO inscritoDTO = new InscritoDTO();

        inscritoDTO.setApellido1(inscrito.getApellido1()== null ? "" :inscrito.getApellido1());
        inscritoDTO.setApellido2(inscrito.getApellido2()== null ? "" :inscrito.getApellido2());
        inscritoDTO.setCarne(inscrito.getCarne()== null ? 0l : inscrito.getCarne());
        inscritoDTO.setCarrera(inscrito.getCarrera()== null ? "" :inscrito.getCarrera());
        inscritoDTO.setCelular(inscrito.getCelular()== null ? "" :inscrito.getCelular());
        inscritoDTO.setCiudad(inscrito.getCiudad()== null ? "" :inscrito.getCiudad());
        inscritoDTO.setCodigo_area(inscrito.getCodigoArea()== null ? "" :inscrito.getCodigoArea());
        inscritoDTO.setDireccion(inscrito.getDireccion()== null ? "" :inscrito.getDireccion());
        inscritoDTO.setDocum(inscrito.getDocum()== null ? "" :inscrito.getDocum());
        inscritoDTO.setEmail(inscrito.getEmail()== null ? "" :inscrito.getEmail());
        //inscritoDTO.setFecha(inscrito.getFecha()== null ? "" :inscrito.getFecha());
        //inscritoDTO.setFechaNac(inscrito.getFechaNac()== null ? "" :inscrito.getFechaNac());
        inscritoDTO.setGrado(inscrito.getGrado()== null ? "" :inscrito.getGrado());
        inscritoDTO.setId_inscripcion(inscrito.getId()== null ? 0 :inscrito.getId());
        inscritoDTO.setId_concurso(inscrito.getIdConcurso()== null ? 0 :inscrito.getIdConcurso());
        inscritoDTO.setInstitucion(inscrito.getInstitucion()== null ? "" :inscrito.getInstitucion());
        inscritoDTO.setNom_grupo(inscrito.getNomGrupo()== null ? "" :inscrito.getNomGrupo());
        inscritoDTO.setNombres(inscrito.getNombres()== null ? "" :inscrito.getNombres());
        inscritoDTO.setNum_orden(inscrito.getNumOrden()== null ? "" :inscrito.getNumOrden());
        inscritoDTO.setParticipo(inscrito.getParticipo()== null ? "" :inscrito.getParticipo());
        inscritoDTO.setPeriodo(inscrito.getPeriodo()== null ? "" :inscrito.getPeriodo());
        inscritoDTO.setTelefono(inscrito.getTelefono()== null ? "" :inscrito.getTelefono());
        inscritoDTO.setTip_doc(inscrito.getTipDoc()== null ? "" :inscrito.getTipDoc());
        inscritoDTO.setTipo_partic(inscrito.getTipoPartic()== null ? "" :inscrito.getTipoPartic());
        inscritoDTO.setpago(inscrito.getpago()== null ? 0 :inscrito.getpago());

        return inscritoDTO;
    }

    @Override
    public InscritoEntity toInscritoEntity(InscritoDTO inscrito) {
        if (inscrito == null) {
            return null;
        }

        InscritoEntity inscritoEntity = new InscritoEntity();

        inscritoEntity.setApellido1(inscrito.getApellido1());
        inscritoEntity.setApellido2(inscrito.getApellido2());
        inscritoEntity.setCarne(inscrito.getCarne());
        inscritoEntity.setCarrera(inscrito.getCarrera());
        inscritoEntity.setCelular(inscrito.getCelular());
        inscritoEntity.setCiudad(inscrito.getCiudad());
        inscritoEntity.setCodigoArea(inscrito.getCodigo_area());
        inscritoEntity.setDireccion(inscrito.getDireccion());
        inscritoEntity.setDocum(inscrito.getDocum());
        inscritoEntity.setEmail(inscrito.getEmail());
        //inscritoEntity.setFecha(inscrito.getFecha());
        //inscritoEntity.setFechaNac(inscrito.getFecha_nac());
        inscritoEntity.setGrado(inscrito.getGrado());
        inscritoEntity.setId(inscrito.getId_inscripcion());
        inscritoEntity.setIdConcurso(inscrito.getId_concurso());
        inscritoEntity.setInstitucion(inscrito.getInstitucion());
        inscritoEntity.setNomGrupo(inscrito.getNom_grupo());
        inscritoEntity.setNombres(inscrito.getNombres());
        inscritoEntity.setNumOrden(inscrito.getNum_orden());
        inscritoEntity.setParticipo(inscrito.getParticipo());
        inscritoEntity.setPeriodo(inscrito.getPeriodo());
        inscritoEntity.setTelefono(inscrito.getTelefono());
        inscritoEntity.setTipDoc(inscrito.getTip_doc());
        inscritoEntity.setTipoPartic(inscrito.getTipo_partic());
        inscritoEntity.setpago(inscrito.getpago());
        return inscritoEntity;
    }

    @Override
    public List<InscritoDTO> map(List<InscritoEntity> inscritos) {
        if (inscritos == null) {
            return null;
        }

        List<InscritoDTO> list = new ArrayList<InscritoDTO>(inscritos.size());
        for (InscritoEntity inscritoEntity : inscritos) {
            list.add(toInscritoDto(inscritoEntity));
        }

        return list;
    }
}
