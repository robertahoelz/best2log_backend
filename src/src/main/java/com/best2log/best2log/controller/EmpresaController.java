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

import com.best2log.best2log.exception.EmpresaAtivadaException;
import com.best2log.best2log.exception.EmpresaDesativadaException;
import com.best2log.best2log.exception.EmpresaNotFoundException;
import com.best2log.best2log.model.dto.EmpresaDTO;
import com.best2log.best2log.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	EmpresaService service;

	@GetMapping
	public ResponseEntity<List<EmpresaDTO>> getAll(@RequestParam(required = false) String data) {
		HttpHeaders header = new HttpHeaders();
		header.add("Empresa-getAll", "Segue uma lista com todas as Empresas");
		return new ResponseEntity<>(service.getAll(data), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/invertido")
	public ResponseEntity<List<EmpresaDTO>> getAllInverted(@RequestParam(required = false) String data) {
		HttpHeaders header = new HttpHeaders();
		header.add("Empresa-getAllInverted", "Segue uma lista com todas as Empresas");
		return new ResponseEntity<>(service.getAllInverted(data), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/inativos")
	public ResponseEntity<List<EmpresaDTO>> getAllInativos(@RequestParam(required = false) String data) {
		HttpHeaders header = new HttpHeaders();
		header.add("Empresa-getAllInactive", "Segue uma lista com todas as Empresas inativas");
		return new ResponseEntity<>(service.getAllInativo(data), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/inativos/invertido")
	public ResponseEntity<List<EmpresaDTO>> getAllInvertedInativos(@RequestParam(required = false) String data) {
		HttpHeaders header = new HttpHeaders();
		header.add("Empresa-getAllInactiveInverted", "Segue uma lista com todas as Empresas inativas");
		return new ResponseEntity<>(service.getAllInativosInverted(data), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmpresaDTO> getOneById(@PathVariable Integer id)
			throws EmpresaNotFoundException, EmpresaDesativadaException {
		HttpHeaders header = new HttpHeaders();
		header.add("Empresa-getOne", "Segue a Empresa");
		return new ResponseEntity<EmpresaDTO>(service.getOne(id), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/buscar/{nome}")
	public ResponseEntity<EmpresaDTO> getOneByNome(@PathVariable String nome)
			throws EmpresaNotFoundException, EmpresaDesativadaException {
		HttpHeaders header = new HttpHeaders();
		header.add("Empresa-getOneName", "Segue a Empresa");
		return new ResponseEntity<EmpresaDTO>(service.getOneByNomeFantasia(nome), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/data/{data}")
	public ResponseEntity<List<EmpresaDTO>> getAllByData(@PathVariable String data) throws EmpresaNotFoundException {
		LocalDate novaData = LocalDate.parse(data);
		HttpHeaders header = new HttpHeaders();
		header.add("Empresa-getAllByData", "Segue a lista de Empresas dessa data");
		return new ResponseEntity<>(service.getAllByData(novaData), header, HttpStatus.valueOf(200));
	}

	@PostMapping
	public ResponseEntity<EmpresaDTO> post(@Valid @RequestBody EmpresaDTO empresa) {
		service.post(empresa);
		HttpHeaders header = new HttpHeaders();
		header.add("Empresa-post", "Empresa adicionada com sucesso");
		return new ResponseEntity<>(header, HttpStatus.valueOf(201));
	}

	@PutMapping("/desativar")
	public ResponseEntity<String> desativarEmpresa(@RequestBody EmpresaDTO id)
			throws EmpresaNotFoundException, EmpresaDesativadaException {
		service.desativarEmpresa(id.getIdEmpresa());
		HttpHeaders header = new HttpHeaders();
		header.add("Empresa-deactivate", "Empresa desativada com sucesso");
		return new ResponseEntity<>(header, HttpStatus.valueOf(202));
	}

	@PutMapping("/ativar")
	public ResponseEntity<String> ativarEmpresa(@RequestBody EmpresaDTO id)
			throws EmpresaNotFoundException, EmpresaAtivadaException {
		service.ativarEmpresa(id.getIdEmpresa());
		HttpHeaders header = new HttpHeaders();
		header.add("Empresa-activate", "Empresa ativada com sucesso");
		return new ResponseEntity<>(header, HttpStatus.valueOf(202));
	}
}
