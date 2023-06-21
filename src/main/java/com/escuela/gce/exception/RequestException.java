package com.escuela.gce.exception;

import com.escuela.gce.helper.constants.ConstantsMessage;

public class RequestException extends Exception {

	public RequestException(String mensaje) {
		super(mensaje);
	}

	public RequestException() {
		super(ConstantsMessage.ERROR_DEFAULT);
	}

}
