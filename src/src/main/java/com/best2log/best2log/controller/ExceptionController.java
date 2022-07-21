package com.best2log.best2log.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.best2log.best2log.exception.CentroDistribuicaoAtivadoException;
import com.best2log.best2log.exception.CentroDistribuicaoDesativadoException;
import com.best2log.best2log.exception.CentroDistribuicaoException;
import com.best2log.best2log.exception.CentroDistribuicaoExistenteException;
import com.best2log.best2log.exception.CentroDistribuicaoNotFoundException;
import com.best2log.best2log.exception.CodigoVerificacaoNotFoundException;
import com.best2log.best2log.exception.EmpresaAtivadaException;
import com.best2log.best2log.exception.EmpresaDesativadaException;
import com.best2log.best2log.exception.EmpresaNotFoundException;
import com.best2log.best2log.exception.FuncionarioNotFoundException;
import com.best2log.best2log.exception.PacoteAtivoException;
import com.best2log.best2log.exception.PacoteDesativadoException;
import com.best2log.best2log.exception.PacoteNotFoundException;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(CentroDistribuicaoAtivadoException.class)
	public ResponseEntity<String> tratarCentroDistribuicaoAtivadoException(CentroDistribuicaoAtivadoException e) {
		return ResponseEntity.status(401).header("error-msg", e.getMessage())
				.header("error-code", "CENTRO_DISTRIBUICAO_ATIVADO").build();
	}

	@ExceptionHandler(CentroDistribuicaoDesativadoException.class)
	public ResponseEntity<String> tratarCentroDistribuicaoDesativadoException(CentroDistribuicaoDesativadoException e) {
		return ResponseEntity.status(401).header("error-msg", e.getMessage())
				.header("error-code", "CENTRO_DISTRIBUICAO_DESATIVADO").build();
	}

	@ExceptionHandler(PacoteDesativadoException.class)
	public ResponseEntity<String> tratarPacoteDesativadoException(PacoteDesativadoException e) {
		return ResponseEntity.status(401).header("error-msg", e.getMessage()).header("error-code", "PACOTE_DESATIVADO")
				.build();
	}

	@ExceptionHandler(PacoteAtivoException.class)
	public ResponseEntity<String> tratarPacoteAtivoException(PacoteAtivoException e) {
		return ResponseEntity.status(401).header("error-msg", e.getMessage()).header("error-code", "PACOTE_ATIVO")
				.build();
	}

	@ExceptionHandler(CentroDistribuicaoException.class)
	public ResponseEntity<String> tratarCentroDistribuicaoException(CentroDistribuicaoException e) {
		return ResponseEntity.status(401).header("error-msg", e.getMessage())
				.header("error-code", "CENTRO_DISTRIBUICAO_VERIFICA_DADOS").build();
	}

	@ExceptionHandler(CentroDistribuicaoExistenteException.class)
	public ResponseEntity<String> tratarCentroDistribuicaoExistenteException(CentroDistribuicaoExistenteException e) {
		return ResponseEntity.status(401).header("error-msg", e.getMessage())
				.header("error-code", "CENTRO_DISTRIBUICAO_EXISTENTE").build();
	}

	@ExceptionHandler(CentroDistribuicaoNotFoundException.class)
	public ResponseEntity<String> tratarCentroDistribuicaoNotFoundException(CentroDistribuicaoNotFoundException e) {
		return ResponseEntity.status(404).header("error-msg", e.getMessage())
				.header("error-code", "CENTRO_DISTRIBUICAO_NOT_FOUND").build();
	}

	@ExceptionHandler(CodigoVerificacaoNotFoundException.class)
	public ResponseEntity<String> tratarCodigoVerificacaoNotFoundException(CodigoVerificacaoNotFoundException e) {
		return ResponseEntity.status(404).header("error-msg", e.getMessage())
				.header("error-code", "CODIGO_VERIFICACAO_NOT_FOUND").build();
	}

	@ExceptionHandler(EmpresaAtivadaException.class)
	public ResponseEntity<String> tratarEmpresaAtivadaException(EmpresaAtivadaException e) {
		return ResponseEntity.status(401).header("error-msg", e.getMessage()).header("error-code", "EMPRESA_ATIVADA")
				.build();
	}

	@ExceptionHandler(EmpresaDesativadaException.class)
	public ResponseEntity<String> tratarEmpresaDesativadaException(EmpresaDesativadaException e) {
		return ResponseEntity.status(401).header("error-msg", e.getMessage()).header("error-code", "EMPRESA_DESATIVADA")
				.build();
	}

	@ExceptionHandler(EmpresaNotFoundException.class)
	public ResponseEntity<String> tratarEmpresaNotFoundException(EmpresaNotFoundException e) {
		return ResponseEntity.status(404).header("error-msg", e.getMessage()).header("error-code", "EMPRESA_NOT_FOUND")
				.build();
	}

	@ExceptionHandler(FuncionarioNotFoundException.class)
	public ResponseEntity<String> tratarFuncionarioNotFoundException(FuncionarioNotFoundException e) {
		return ResponseEntity.status(404).header("error-msg", e.getMessage())
				.header("error-code", "FUNCIONARIO_NOT_FOUND").build();
	}

	@ExceptionHandler(PacoteNotFoundException.class)
	public ResponseEntity<String> tratarPacoteNotFoundException(PacoteNotFoundException e) {
		return ResponseEntity.status(404).header("error-msg", e.getMessage()).header("error-code", "PACOTE_NOT_FOUND")
				.build();
	}

}
