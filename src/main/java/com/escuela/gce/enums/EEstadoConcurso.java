package com.escuela.gce.enums;

public enum EEstadoConcurso {
	INACTIVO("N"), ACTIVO("S");

	private final String code;

	private EEstadoConcurso(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
