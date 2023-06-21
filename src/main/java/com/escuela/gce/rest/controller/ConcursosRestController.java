package com.escuela.gce.rest.controller;

import org.json.JSONException;

import com.escuela.gce.exception.ModelException;
import com.escuela.gce.exception.ServerException;
import com.escuela.gce.helper.validators.ConcursoValidator;
import com.escuela.gce.model.dto.ApiErrorDTO;
import com.escuela.gce.model.dto.ConcursoDTO;
import com.escuela.gce.model.dto.ConcursoDesplegableDTO;
import com.escuela.gce.model.dto.RespuestaConcursoDesplegableDTO;
import com.escuela.gce.rest.response.GCEPaginationResponse;
import com.escuela.gce.rest.response.PaginationResponse;
import com.escuela.gce.service.IConcursoService;
import com.escuela.gce.service.impl.ConcursoService;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("concursos/v1")
public class ConcursosRestController {

    public static final Logger log = Logger.getLogger("ConcursosRestController");

    @Context
    private UriInfo context;

    public ConcursosRestController() {
        this.service = new ConcursoService();
    }

    private final IConcursoService service;

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ConcursoDTO consultarPorId(@PathParam("id") int id) throws ModelException {
        try {
            log.info("Starting get Concurso by id");
            return service.consultarPorId(id);
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/counter")
    public Long contar() throws ModelException {
        try {
            return service.contar();
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }
    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/all")
    public RespuestaConcursoDesplegableDTO allConcursos() throws ModelException {
        RespuestaConcursoDesplegableDTO respuesta = new RespuestaConcursoDesplegableDTO();
        try {
            List <ConcursoDesplegableDTO> listConcurso=service.allConcursos();
            if(listConcurso != null && !listConcurso.isEmpty()){
                respuesta.setCodigo(0);
                respuesta.setMensaje("Respuesta Correcta");
                respuesta.setListaConcursos(listConcurso);
            }else{
                respuesta.setCodigo(1);
                respuesta.setMensaje("No existen concursos en la BD");
                
            }
        } catch (JSONException error) {
           respuesta.setCodigo(2);
           respuesta.setMensaje(error.getMessage());
        }
        return respuesta;
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/filter")
    public GCEPaginationResponse consultarPorFiltros(ConcursoDTO concurso) throws ModelException {
        try {
            log.info("Starting filter list of Concursos");
//            Map<String, String> params = UtilResponse.buildCriteriaParams(request);
            if (concurso != null) {
                List<ConcursoDTO> data = service.consultarPorFiltros(concurso, new HashMap<String, String>());
                GCEPaginationResponse response = new GCEPaginationResponse();
                PaginationResponse pagination = new PaginationResponse();
                pagination.setRecordCount(data.size());
                pagination.setTotalCount(service.contar());
                if (data != null) {
                    response.setData(data);
                    response.setPagination(pagination);
                }

                return response;
            } else {
                return new GCEPaginationResponse();
            }
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/create")
    public ConcursoDTO saveConcurso(ConcursoDTO concurso) throws ModelException {
        try {
            log.info("Starting create a Concurso");
            ApiErrorDTO apiError = ConcursoValidator.validarConcurso(concurso);
            if (apiError == null) {
                return service.crear(concurso);
            } else {
                return new ConcursoDTO();
            }
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/update")
    public ConcursoDTO modificar(ConcursoDTO concurso) throws ModelException {
        try {
            ApiErrorDTO apiError = ConcursoValidator.validarConcurso(concurso);
            if (apiError == null) {
                int id = concurso != null ? concurso.getId_concurso() : 0;
                log.info(String.format("Starting update Concurso %s", id));
                ConcursoDTO concursoEncontrado = service.consultarPorId(id);
                if (concursoEncontrado != null) {
                    return service.modificar(concurso);
                } else {
                    return new ConcursoDTO();
                }
            } else {
                return new ConcursoDTO();
            }
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

    @GET
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/inactivate/{id}")
    public ConcursoDTO inactive(@PathParam("id") int id) throws ModelException {
        try {
            log.info(String.format("Starting inactive Concurso %s", id));
            return service.inactivar(id);
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

}
