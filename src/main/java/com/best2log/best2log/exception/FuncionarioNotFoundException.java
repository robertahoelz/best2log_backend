package com.best2log.best2log.exception;

public class FuncionarioNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "Nao foi possivel localizar os dados do funcionario!";
	}
	
}
