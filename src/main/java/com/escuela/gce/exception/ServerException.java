package com.escuela.gce.exception;

import com.escuela.gce.helper.constants.ConstantsMessage;

public class ServerException extends RuntimeException {

	public ServerException(String mensaje) {
		super(mensaje);
	}

	public ServerException() {
		super(ConstantsMessage.ERROR_INTERNAL_SERVER_DEFAULT);
	}

}
