package com.escuela.gce.exception;

import com.escuela.gce.helper.constants.ConstantsMessage;

public class NotFoundException extends Exception {

	public NotFoundException(String mensaje) {
		super(mensaje);
	}

	public NotFoundException() {
		super(ConstantsMessage.ERROR_DEFAULT);
	}

}
