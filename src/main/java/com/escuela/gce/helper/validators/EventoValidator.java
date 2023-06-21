package com.escuela.gce.helper.validators;

import org.apache.commons.lang3.StringUtils;

import com.escuela.gce.helper.constants.ConstantsValidators;
import com.escuela.gce.helper.util.UtilResponse;
import com.escuela.gce.model.dto.ApiErrorDTO;
import com.escuela.gce.model.dto.EventoDTO;

public final class EventoValidator {

    private EventoValidator() {
    }

    public static ApiErrorDTO validarEvento(EventoDTO evento) {
        ApiErrorDTO errorDTO = null;
        if (evento == null || StringUtils.isBlank(evento.getNombre())) {
            errorDTO = UtilResponse.buildApiError(ConstantsValidators.BAD_REQUEST);
        }
        return errorDTO;
    }
}
