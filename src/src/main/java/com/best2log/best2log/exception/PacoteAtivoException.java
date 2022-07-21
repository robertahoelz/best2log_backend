package com.best2log.best2log.exception;

public class PacoteAtivoException extends Exception {

	@Override
	public String getMessage() {
		return "Este Pacote ja estava ativo!";
	}
}
