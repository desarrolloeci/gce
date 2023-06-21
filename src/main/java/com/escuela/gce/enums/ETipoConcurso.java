package com.escuela.gce.enums;

public enum ETipoConcurso {
	INDIVIDUAL("I"), GRUPAL("G");

	private final String code;

	private ETipoConcurso(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
