package com.best2log.best2log.exception;

public class CentroDistribuicaoAtivadoException extends Exception {

	@Override
	public String getMessage() {
		return "Este Centro de Distribuicao ja estava ativo";
	}
	
}
