package com.best2log.best2log.model.dto;


import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PacoteDTO {
	
	private Integer idPacote;
	
	
	private String statusPacote;
	

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataEntrada;

	
	@NotNull(message = "O CEP não pode ser nulo.")
	private String cep;
	
	
	private EnderecoDTO endereco;
	
	
	private EmpresaDTO empresa;
	
	private CentroDistribuicaoDTO cd;
	
	
	

	

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public CentroDistribuicaoDTO getCd() {
		return cd;
	}

	public void setCd(CentroDistribuicaoDTO cd) {
		this.cd = cd;
	}

	public Integer getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(Integer idPacote) {
		this.idPacote = idPacote;
	}

	public String getStatusPacote() {
		return statusPacote;
	}

	public void setStatusPacote(String statusPacote) {
		this.statusPacote = statusPacote;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	
	
}
