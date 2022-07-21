package com.best2log.best2log.exception;

public class EmpresaAtivadaException extends Exception {

	@Override
	public String getMessage() {
		return "Esta empresa ja estava ativa!";
	}

}
