package com.escuela.gce.rest.controller;

import java.util.List;

import org.json.JSONException;

import com.escuela.gce.exception.ModelException;
import com.escuela.gce.exception.ServerException;
import com.escuela.gce.model.dto.InscritoDTO;
import com.escuela.gce.rest.response.GCEPaginationResponseInscritos;
import com.escuela.gce.rest.response.PaginationResponse;
import com.escuela.gce.service.IInscritoService;
import com.escuela.gce.service.impl.InscritoService;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/inscritos/v1")
public class InscritosRestController {

    public static final Logger log = Logger.getLogger("InscritosRestController");

    @Context
    private UriInfo context;

    public InscritosRestController() {
        this.service = new InscritoService();
    }

    private final IInscritoService service;

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public InscritoDTO consultarPorId(@PathParam("id") int id) throws ModelException {
        try {
            log.info("Starting get Inscrito by id");
            return service.consultarPorId(id);
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/filter")
    public GCEPaginationResponseInscritos consultarPorFiltros(InscritoDTO inscrito) throws ModelException {
        try {
            log.info("Starting filter list of Inscritos");
//            Map<String, String> params = UtilResponse.buildCriteriaParams(request);
            if (inscrito != null) {
                List<InscritoDTO> data = service.consultarPorFiltros(inscrito, new HashMap<String, String>());
                GCEPaginationResponseInscritos response = new GCEPaginationResponseInscritos();
                PaginationResponse pagination = new PaginationResponse();
                pagination.setRecordCount(data.size());
                pagination.setTotalCount(data.size());
                if (data != null) {
                    response.setData(data);
                    response.setPagination(pagination);
                }
                return response;
            } else {
                return new GCEPaginationResponseInscritos();
            }
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

}
