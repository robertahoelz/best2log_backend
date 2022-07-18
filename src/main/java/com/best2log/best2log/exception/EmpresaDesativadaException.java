package com.best2log.best2log.exception;

public class EmpresaDesativadaException extends Exception {

	@Override
	public String getMessage() {
		return "Esta empresa ja estava desativada!";
	}
	
}
