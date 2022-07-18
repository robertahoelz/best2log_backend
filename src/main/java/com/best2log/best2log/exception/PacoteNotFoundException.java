package com.best2log.best2log.exception;

public class PacoteNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "Nao foi possivel encontrar o pacote solicitado";
	}
	
}
