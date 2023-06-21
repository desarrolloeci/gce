/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.gce.rest.controller;

import com.escuela.gce.exception.ModelException;
import com.escuela.gce.exception.NotFoundException;
import com.escuela.gce.exception.ServerException;
import com.escuela.gce.model.dto.AsistenciaDTO;
import com.escuela.gce.model.dto.AsistenciaMapperDTO;
import com.escuela.gce.model.dto.InscritoDTO;
import com.escuela.gce.model.dto.PublicoDTO;
import com.escuela.gce.model.dto.RequestAsistenciaDTO;
import com.escuela.gce.model.dto.RequestListadoAsistenciaDTO;
import com.escuela.gce.model.dto.ResponseAsistenciaDTO;
import com.escuela.gce.model.dto.ResponseListadoAsistenciaDTO;
import com.escuela.gce.model.mapper.ConcursoMapperImpl;
import com.escuela.gce.model.persistence.AsistenciaEntity;
import static com.escuela.gce.rest.controller.PublicosRestController.log;
import com.escuela.gce.rest.response.GCEPaginationResponsePublico;
import com.escuela.gce.rest.response.PaginationResponse;
import com.escuela.gce.service.IAsistenciaService;
import com.escuela.gce.service.IInscritoService;
import com.escuela.gce.service.IPublicoService;
import com.escuela.gce.service.impl.AsistenciaService;
import com.escuela.gce.service.impl.InscritoService;
import com.escuela.gce.service.impl.PublicoService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.json.JSONException;

/**
 *
 * @author desarrollador3
 */
@Path("/asistencia/v1")
public class AsistenciaRestController {

    public static final Logger log = Logger.getLogger("AsistenciaRestController");

    @Context
    private UriInfo context;

    public AsistenciaRestController() {
        this.serviceIns = new InscritoService();
        this.serviceAsis = new AsistenciaService();
    }

    private final IInscritoService serviceIns;

    private final IAsistenciaService serviceAsis;

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/crearAsistencia")
    public ResponseAsistenciaDTO crearAsistencia(RequestAsistenciaDTO request) throws ModelException {
        ResponseAsistenciaDTO response = new ResponseAsistenciaDTO();
        try {
            log.info("Starting crear asistencia");
            if (request != null) {
                log.info("Validar Usuario inscrito");
                List<InscritoDTO> data = serviceIns.consultarPorConcursoCedula(request.getId_concurso(), request.getCedula());
                if (data != null && !data.isEmpty()) {
                    AsistenciaEntity nuevo = new AsistenciaEntity();
                    nuevo.setIdConcurso(data.get(0).getId_concurso());
                    nuevo.setIdParticipante(data.get(0).getDocum());
                    List<AsistenciaEntity> dataAsis = serviceAsis.consultarAsistenciaExistente(nuevo);
                    if (dataAsis != null && !dataAsis.isEmpty()) {
                        response.setCodigo(4);
                        response.setMensaje("La asistencia ya ha sido registrada con anterioridad");
                    } else {
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed;
                        try {
                            String date = formato.format(new Date());
                            parsed = formato.parse(date);
                            nuevo.setFechaInicio(new java.sql.Date(parsed.getTime()));
                        } catch (ParseException ex) {
                            Logger.getLogger(ConcursoMapperImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        AsistenciaEntity dato =serviceAsis.crear(nuevo);
                        if(dato.getId() != null){
                            response.setCodigo(0);
                            response.setMensaje("Asistencia registrada correctamente");
                        }else{
                            response.setCodigo(5);
                            response.setMensaje("Ocurrio un error al registrar asistencia");
                        }
                    }
                } else {
                    response.setCodigo(3);
                    response.setMensaje("La cedula no se encuentra registrada en el concurso");
                }
            } else {
                response.setCodigo(2);
                response.setMensaje("validar request enviado");
            }
        } catch (JSONException error) {
            response.setCodigo(1);
            response.setMensaje(error.getMessage());
        }
        return response;
    }
    
    
            
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/ListarAsistencia")
    public ResponseListadoAsistenciaDTO crearAsistencia(RequestListadoAsistenciaDTO request) throws ModelException {
        ResponseListadoAsistenciaDTO response = new ResponseListadoAsistenciaDTO();
        try {
            List<AsistenciaMapperDTO> dataAsis = serviceAsis.consultarListadoAsistencia(request.getId_concurso());
            response.setCodigo(0);
            response.setMensaje("Consulta realizada");
            response.setListaAsistencia(dataAsis);
            
        } catch (JSONException error) {
            response.setCodigo(1);
            response.setMensaje(error.getMessage());
        }
        return response;
    }        
}
