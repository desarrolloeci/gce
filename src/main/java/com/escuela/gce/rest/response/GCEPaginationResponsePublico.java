package com.escuela.gce.rest.response;

import com.escuela.gce.model.dto.ConcursoDTO;
import com.escuela.gce.model.dto.EventoDTO;
import com.escuela.gce.model.dto.InscritoDTO;
import com.escuela.gce.model.dto.PublicoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;




@JsonPropertyOrder({ "pagination" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCEPaginationResponsePublico {

    
        @JsonProperty("data")
        private List<PublicoDTO> data;
    
	@JsonProperty("pagination")
	private PaginationResponse pagination;

    public GCEPaginationResponsePublico() {
    }

    public PaginationResponse getPagination() {
        return pagination;
    }

    public void setPagination(PaginationResponse pagination) {
        this.pagination = pagination;
    }

    public List<PublicoDTO> getData() {
        return data;
    }

    public void setData(List<PublicoDTO> data) {
        this.data = data;
    }


    
 
        
        
}
