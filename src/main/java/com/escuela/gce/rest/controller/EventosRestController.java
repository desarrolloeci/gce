package com.escuela.gce.rest.controller;

import java.util.List;

import org.json.JSONException;

import com.escuela.gce.exception.ModelException;
import com.escuela.gce.exception.ServerException;
import com.escuela.gce.helper.validators.EventoValidator;
import com.escuela.gce.model.dto.ApiErrorDTO;
import com.escuela.gce.model.dto.EventoDTO;
import com.escuela.gce.rest.response.GCEPaginationResponseEventos;
import com.escuela.gce.rest.response.PaginationResponse;
import com.escuela.gce.service.IEventoService;
import com.escuela.gce.service.impl.EventoService;
import java.util.HashMap;
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

@Path("/eventos/v1")
public class EventosRestController {

    public static final Logger log = Logger.getLogger("EventosRestController");

    @Context
    private UriInfo context;

    public EventosRestController() {
        this.service = new EventoService();
    }

    private final IEventoService service;

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public EventoDTO consultarPorId(@PathParam("id") int id) throws ModelException {
        try {
            log.info("Starting get Evento by id");
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

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/filter")
    public GCEPaginationResponseEventos consultarPorFiltros(EventoDTO evento) throws ModelException {
        try {
            log.info("Starting filter list of Eventos");
//            Map<String, String> params = UtilResponse.buildCriteriaParams(request);
            if (evento != null) {
                List<EventoDTO> data = service.consultarPorFiltros(evento, new HashMap<String, String>());
                GCEPaginationResponseEventos response = new GCEPaginationResponseEventos();
                PaginationResponse pagination = new PaginationResponse();
                pagination.setRecordCount(data.size());
                pagination.setTotalCount(service.contar());
                if (data != null) {
                    response.setData(data);
                    response.setPagination(pagination);
                }
                return response;
            } else {
                return new GCEPaginationResponseEventos();
            }
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/create")
    public EventoDTO saveEvento(EventoDTO evento) throws ModelException {
        try {
            log.info("Starting create a Evento");
            ApiErrorDTO apiError = EventoValidator.validarEvento(evento);
            if (apiError == null) {
                return service.crear(evento);
            } else {
                return new EventoDTO();
            }
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/update")
    public EventoDTO modificar(EventoDTO evento) throws ModelException {
        try {
            ApiErrorDTO apiError = EventoValidator.validarEvento(evento);
            if (apiError == null) {
                int id = evento != null ? evento.getId_evento() : 0;
                EventoDTO eventoEncontrado = service.consultarPorId(id);
                if (eventoEncontrado != null) {
                    return service.modificar(evento);
                } else {
                    return new EventoDTO();
                }
            } else {
                return new EventoDTO();
            }
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

    @GET
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/inactivate/{id}")
    public EventoDTO inactive(@PathParam("id") int id) throws ModelException {
        try {
            log.info(String.format("Starting inactive Evento %s", id));
            return service.inactivar(id);
        } catch (JSONException error) {
            throw new ServerException(error.getMessage());
        }
    }

}
