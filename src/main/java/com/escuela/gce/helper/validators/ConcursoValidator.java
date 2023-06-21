package com.escuela.gce.helper.validators;

import org.apache.commons.lang3.StringUtils;

import com.escuela.gce.helper.constants.ConstantsValidators;
import com.escuela.gce.helper.util.UtilResponse;
import com.escuela.gce.model.dto.ApiErrorDTO;
import com.escuela.gce.model.dto.ConcursoDTO;

public final class ConcursoValidator {

    private ConcursoValidator() {
    }

    public static ApiErrorDTO validarConcurso(ConcursoDTO concurso) {
        ApiErrorDTO errorDTO = null;
        if (StringUtils.isBlank(concurso.getNombre())) {
            errorDTO = UtilResponse.buildApiError(ConstantsValidators.BAD_REQUEST);
        }
        return errorDTO;
    }

}
