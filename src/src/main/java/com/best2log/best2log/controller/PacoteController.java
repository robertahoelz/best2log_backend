package com.best2log.best2log.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.best2log.best2log.exception.CentroDistribuicaoDesativadoException;
import com.best2log.best2log.exception.CentroDistribuicaoNotFoundException;
import com.best2log.best2log.exception.EmpresaDesativadaException;
import com.best2log.best2log.exception.EmpresaNotFoundException;
import com.best2log.best2log.exception.PacoteAtivoException;
import com.best2log.best2log.exception.PacoteDesativadoException;
import com.best2log.best2log.exception.PacoteNotFoundException;
import com.best2log.best2log.model.dto.PacoteDTO;
import com.best2log.best2log.service.PacoteService;

@RestController
@RequestMapping("/pacote")
public class PacoteController {

	@Autowired
	PacoteService service;

	@GetMapping
	public ResponseEntity<List<PacoteDTO>> getAll(@RequestParam(required = false) String data)
			throws EmpresaDesativadaException, EmpresaNotFoundException {
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-getAll", "Segue uma lista com todos os Pacotes");
		return new ResponseEntity<>(service.getAll(data), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/lixeira")
	public ResponseEntity<List<PacoteDTO>> getAllLixeira(@RequestParam(required = false) String data)
			throws EmpresaDesativadaException, EmpresaNotFoundException {
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-getAllLixeira", "Segue uma lista com todos os Pacotes da Lixeira");
		return new ResponseEntity<>(service.getAllLixeira(data), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/invertido")
	public ResponseEntity<List<PacoteDTO>> getAllInverted(@RequestParam(required = false) String data)
			throws EmpresaDesativadaException, EmpresaNotFoundException {
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-getAllInverted", "Segue uma lista com todas os Pacotes");
		return new ResponseEntity<>(service.getAllInverted(data), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/lixeira/invertido")
	public ResponseEntity<List<PacoteDTO>> getAllInvertedLixeira(@RequestParam(required = false) String data)
			throws EmpresaDesativadaException, EmpresaNotFoundException {
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-getAllLixeiraInverted", "Segue uma lista com todos os Pacotes da Lixeira");
		return new ResponseEntity<>(service.getAllInvertedLixeira(data), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/empresa/{nome}")
	public ResponseEntity<List<PacoteDTO>> getAllByEmpresa(@PathVariable String nome)
			throws EmpresaDesativadaException, EmpresaNotFoundException {
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-getAllByEmpresa", "Segue uma lista com todos os Pacotes dessa empresa");
		return new ResponseEntity<>(service.getAllByEmpresa(nome), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/buscar/{cep}")
	public ResponseEntity<List<PacoteDTO>> getAllByCep(@Valid @PathVariable String cep)
			throws PacoteNotFoundException, EmpresaDesativadaException {
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-getOneCep", "Segue o Pacote");
		return new ResponseEntity<>(service.getAllByCep(cep), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/buscar/data/{data}")
	public ResponseEntity<List<PacoteDTO>> getAllByData(@PathVariable String data)
			throws PacoteNotFoundException, EmpresaDesativadaException {
		LocalDate novaData = LocalDate.parse(data);
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-getAllByData", "Segue os Pacotes dessa data");
		return new ResponseEntity<>(service.getAllByData(novaData), header, HttpStatus.valueOf(200));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PacoteDTO> getOneById(@PathVariable Integer id)
			throws PacoteNotFoundException, EmpresaDesativadaException {
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-getOneId", "Segue o Pacote");
		return new ResponseEntity<>(service.getOne(id), header, HttpStatus.valueOf(200));
	}

	@PostMapping
	public ResponseEntity<PacoteDTO> post(@Valid @RequestBody PacoteDTO pacote) throws EmpresaNotFoundException,
			EmpresaDesativadaException, CentroDistribuicaoNotFoundException, CentroDistribuicaoDesativadoException {
		service.post(pacote);
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-post", "Pacote adicionado com sucesso");
		return new ResponseEntity<>(header, HttpStatus.valueOf(201));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PacoteDTO> put(@Valid @RequestBody PacoteDTO pacote, @PathVariable Integer id)
			throws EmpresaNotFoundException, EmpresaDesativadaException, CentroDistribuicaoNotFoundException,
			CentroDistribuicaoDesativadoException, PacoteNotFoundException {
		service.update(id, pacote);
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-update", "Pacote atualizado com sucesso");
		return new ResponseEntity<>(header, HttpStatus.valueOf(202));
	}

	@PutMapping("/desativar")
	public ResponseEntity<String> deactivate(@RequestBody PacoteDTO id)
			throws PacoteNotFoundException, PacoteDesativadoException {
		service.deactivate(id.getIdPacote());
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-delete", "Pacote foi pra lixeira");
		return new ResponseEntity<>(header, HttpStatus.valueOf(202));
	}

	@PutMapping("/ativar")
	public ResponseEntity<String> activate(@RequestBody PacoteDTO id)
			throws PacoteNotFoundException, PacoteAtivoException {
		service.activate(id.getIdPacote());
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-delete", "Pacote saiu da lixeira");
		return new ResponseEntity<>(header, HttpStatus.valueOf(202));
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id)
			throws PacoteNotFoundException, PacoteAtivoException {
		service.delete(id);
		HttpHeaders header = new HttpHeaders();
		header.add("Pacote-delete", "Pacote deletado com sucesso");
		return new ResponseEntity<>(header, HttpStatus.valueOf(202));
	}
}
