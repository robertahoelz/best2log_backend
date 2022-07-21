package com.best2log.best2log.exception;

public class EmpresaNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "Nao foi possivel encontrar a empresa solicitada!";
	}

}
