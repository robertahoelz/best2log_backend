package com.best2log.best2log.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.best2log.best2log.exception.CentroDistribuicaoAtivadoException;
import com.best2log.best2log.exception.CentroDistribuicaoDesativadoException;
import com.best2log.best2log.exception.CentroDistribuicaoExistenteException;
import com.best2log.best2log.exception.CentroDistribuicaoNotFoundException;
import com.best2log.best2log.model.dto.CentroDistribuicaoDTO;
import com.best2log.best2log.service.CentroDistribuicaoService;

@RestController
@RequestMapping("/centro")
public class CentroDistribuicaoController {

	@Autowired
	CentroDistribuicaoService service;

	@GetMapping
	public ResponseEntity<List<CentroDistribuicaoDTO>> getAll(@RequestParam (required=false) LocalDate data) {
		HttpHeaders header = new HttpHeaders();
		header.add("centroDistribuicao-getAll", "Segue uma lista com todas os Centros de Distribuição");
		return new ResponseEntity<>(service.getAll(data), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CentroDistribuicaoDTO> getOneById(@PathVariable Integer id)
			throws CentroDistribuicaoNotFoundException, CentroDistribuicaoDesativadoException {
		HttpHeaders header = new HttpHeaders();
		header.add("centroDistribuicao-getOne", "Segue o Centro de Distribuição");
		return new ResponseEntity<CentroDistribuicaoDTO>(service.getOne(id), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/cnpj/{cnpj}")
	public ResponseEntity<CentroDistribuicaoDTO> getOneByCnpj(@Valid @PathVariable String cnpj)
			throws CentroDistribuicaoNotFoundException, CentroDistribuicaoDesativadoException {
		HttpHeaders header = new HttpHeaders();
		header.add("centroDistribuicao-getOne", "Segue o Centro de Distribuição");
		return new ResponseEntity<CentroDistribuicaoDTO>(service.getOneByCnpj(cnpj), header, HttpStatus.valueOf(200));
	}

	@PostMapping
	public ResponseEntity<String> post(@Valid @RequestBody CentroDistribuicaoDTO cd)
			throws CentroDistribuicaoExistenteException {
		service.post(cd);
		HttpHeaders header = new HttpHeaders();
		header.add("centroDistribuicao-post", "Centro de Distribuição cadastrado com sucesso!");
		return new ResponseEntity<>(header, HttpStatus.valueOf(201));
	}

	@PutMapping("/ativar/{id}")
	public ResponseEntity<String> ativar(@PathVariable Integer id)
			throws CentroDistribuicaoNotFoundException, CentroDistribuicaoAtivadoException {
		service.ativarCD(id);
		HttpHeaders header = new HttpHeaders();
		header.add("centroDistribuicao-activate", "Centro de Distribuição ativado com sucesso!");
		return new ResponseEntity<>(header, HttpStatus.valueOf(202));
	}

	@PutMapping("/desativar/{id}")
	public ResponseEntity<String> desativar(@PathVariable Integer id)
			throws CentroDistribuicaoNotFoundException, CentroDistribuicaoDesativadoException {
		service.desativarCD(id);
		HttpHeaders header = new HttpHeaders();
		header.add("centroDistribuicao-deactivate", "Centro de Distribuição desativado com sucesso!");
		return new ResponseEntity<>(header, HttpStatus.valueOf(202));
	}
}
