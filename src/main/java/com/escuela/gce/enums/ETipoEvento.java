package com.escuela.gce.enums;

public enum ETipoEvento {
	CONCURSO("C"), CONFERENCIA("F"), RETO("R");

	private final String code;

	private ETipoEvento(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
