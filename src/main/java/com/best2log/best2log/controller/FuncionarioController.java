package com.best2log.best2log.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.best2log.best2log.exception.CodigoVerificacaoNotFoundException;
import com.best2log.best2log.exception.FuncionarioNotFoundException;
import com.best2log.best2log.model.dto.FuncionarioDTO;
import com.best2log.best2log.model.dto.RedefinirSenhaDTO;
import com.best2log.best2log.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioService service;

	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioDTO> getOneById(@PathVariable Integer id) throws FuncionarioNotFoundException {
		HttpHeaders header = new HttpHeaders();
		header.add("Funcionario-getOneById", "Segue o Funcionario");
		return new ResponseEntity<FuncionarioDTO>(service.getOne(id), header, HttpStatus.valueOf(200));
	}
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<FuncionarioDTO> getOneByCpf(@PathVariable String cpf) throws FuncionarioNotFoundException {
		HttpHeaders header = new HttpHeaders();
		header.add("Funcionario-getOneByCpf", "Segue o Funcionario");
		return new ResponseEntity<FuncionarioDTO>(service.getOneByCpf(cpf), header, HttpStatus.valueOf(200));
	}
	@GetMapping("/email/{email}")
	public ResponseEntity<FuncionarioDTO> getOneByEmail(@PathVariable String email) throws FuncionarioNotFoundException {
		HttpHeaders header = new HttpHeaders();
		header.add("Funcionario-getOneByCpf", "Segue o Funcionario");
		return new ResponseEntity<FuncionarioDTO>(service.getOneByEmail(email), header, HttpStatus.valueOf(200));
	}

	@PostMapping
	public ResponseEntity<String> post(@Valid @RequestBody FuncionarioDTO funcionario) {
		service.post(funcionario);
		HttpHeaders header = new HttpHeaders();
		header.add("Funcionario-post", "Funcionario adicionado com sucesso");
		return new ResponseEntity<>(header, HttpStatus.valueOf(201));
	}

	@PostMapping("/redefinir")
	public ResponseEntity<String> redefinirSenha(@RequestBody RedefinirSenhaDTO dto)
			throws FuncionarioNotFoundException, CodigoVerificacaoNotFoundException {
		service.redefinirSenha(dto);
		HttpHeaders header = new HttpHeaders();
		header.add("Funcionario-redefine", " Senha redefinida com sucesso");
		return new ResponseEntity<>(header, HttpStatus.valueOf(202));
	}

	@PostMapping("/enviarCodigo")
	public ResponseEntity<String> sendCode(@RequestBody RedefinirSenhaDTO dto)
			throws UnsupportedEncodingException, FuncionarioNotFoundException, MessagingException {
		service.sendCode(dto.getEmail());
		HttpHeaders header = new HttpHeaders();
		header.add("Funcionario-sendCode", " Código enviado com sucesso");
		return new ResponseEntity<>(header, HttpStatus.valueOf(202));

	}
}
