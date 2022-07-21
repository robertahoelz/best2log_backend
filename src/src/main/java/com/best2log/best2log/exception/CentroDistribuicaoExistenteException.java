package com.best2log.best2log.exception;

public class CentroDistribuicaoExistenteException extends Exception {

	@Override
	public String getMessage() {
		return "Este Centro de Distribuicao ja existe. Verifique os dados de cadastro.";
	}

}
