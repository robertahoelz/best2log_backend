package com.best2log.best2log.model.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;



public class EmpresaDTO {

	private Integer idEmpresa;
	
	@CNPJ
	@NotBlank(message = "CNPJ não informado")
	@Size(min = 14, max =14, message = "O CNPJ deverá ter 14 caracteres(Sem traços, pontos e barras)")
	private String cnpj;
	
	@NotBlank(message = "Razão Social não informada")
    @Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	@Size(max = 100, message = "A Razão Social deverá ter no máximo 100 caracteres")
	private String razaoSocial;
	
	@Size(max = 100, message = "O nome fantasia deverá ter no máximo 100 caracteres")
	private String nomeFantasia;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCadastro;
	
	private boolean ativo=true;
	
	@Column(nullable=false)
	private EnderecoDTO endereco;

	
	
	

	public EmpresaDTO() {
		super();
	}

	public EmpresaDTO(Integer idEmpresa, String cnpj, String razaoSocial, String nomeFantasia, LocalDate dataCadastro,
			boolean ativo, EnderecoDTO endereco) {
		super();
		this.idEmpresa = idEmpresa;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
		this.endereco = endereco;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
