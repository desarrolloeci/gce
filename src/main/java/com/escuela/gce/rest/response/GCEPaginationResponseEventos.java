package com.escuela.gce.rest.response;

import com.escuela.gce.model.dto.ConcursoDTO;
import com.escuela.gce.model.dto.EventoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;




@JsonPropertyOrder({ "pagination" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCEPaginationResponseEventos {

    
        @JsonProperty("data")
        private List<EventoDTO> data;
    
	@JsonProperty("pagination")
	private PaginationResponse pagination;

    public GCEPaginationResponseEventos() {
    }

    public PaginationResponse getPagination() {
        return pagination;
    }

    public void setPagination(PaginationResponse pagination) {
        this.pagination = pagination;
    }

    public List<EventoDTO> getData() {
        return data;
    }

    public void setData(List<EventoDTO> data) {
        this.data = data;
    }


    
 
        
        
}
