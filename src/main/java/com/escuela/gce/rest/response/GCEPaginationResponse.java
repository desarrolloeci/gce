package com.escuela.gce.rest.response;

import com.escuela.gce.model.dto.ConcursoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;




@JsonPropertyOrder({ "pagination" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCEPaginationResponse {

    
        @JsonProperty("data")
        private List<ConcursoDTO> data;
    
	@JsonProperty("pagination")
	private PaginationResponse pagination;

    public GCEPaginationResponse() {
    }

    public PaginationResponse getPagination() {
        return pagination;
    }

    public void setPagination(PaginationResponse pagination) {
        this.pagination = pagination;
    }

    public List<ConcursoDTO> getData() {
        return data;
    }

    public void setData(List<ConcursoDTO> data) {
        this.data = data;
    }


    
 
        
        
}
