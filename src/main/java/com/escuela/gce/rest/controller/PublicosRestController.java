package com.escuela.gce.rest.controller;

import java.util.List;

import org.json.JSONException;

import com.escuela.gce.exception.ModelException;
import com.escuela.gce.exception.NotFoundException;
import com.escuela.gce.exception.ServerException;
import com.escuela.gce.model.dto.PublicoDTO;
import com.escuela.gce.rest.response.GCEPaginationResponsePublico;
import com.escuela.gce.rest.response.PaginationResponse;
import com.escuela.gce.service.IPublicoService;
import com.escuela.gce.service.impl.PublicoService;
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

@Path("/publico/v1")
public class PublicosRestController {

    public static final Logger log = Logger.getLogger("PublicosRestController");

    @Context
    private UriInfo context;

    public PublicosRestController() {
        this.service = new PublicoService();
    }

    private final IPublicoService service;

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public PublicoDTO consultarPorId(@PathParam("id") int id) throws NotFoundException, ModelException {
        try {
            log.info("Starting get Publico by id");
            return service.consultarPorId(id);
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/filter")
    public GCEPaginationResponsePublico consultarPorFiltros(PublicoDTO publico) throws ModelException {
        try {
            log.info("Starting filter list of Publicos");
//            Map<String, String> params = UtilResponse.buildCriteriaParams(request);
            if (publico != null) {
                List<PublicoDTO> data = service.consultarPorFiltros(publico, new HashMap<String, String>());
                GCEPaginationResponsePublico response = new GCEPaginationResponsePublico();
                PaginationResponse pagination = new PaginationResponse();
                pagination.setRecordCount(data.size());
                pagination.setTotalCount(data.size());
                if (data != null) {
                    response.setData(data);
                    response.setPagination(pagination);
                }
                return response;
            } else {
                return new GCEPaginationResponsePublico();
            }
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

}
