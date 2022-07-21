package com.best2log.best2log.model.dto;



import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

public class CentroDistribuicaoDTO {

	private Integer idCentroDistribuicao;

	@CNPJ
	@NotBlank(message = "CNPJ não informado")
	@Size(min = 14, max = 14, message = "O CNPJ deverá ter 14 caracteres(Sem traços, pontos e barras)")
	private String cnpj;

	@NotBlank(message = "Razão Social não informada")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	@Size(max = 100, message = "A Razão Social deverá ter no máximo 100 caracteres")
	private String razaoSocial;

	@Size(max = 100, message = "O nome fantasia deverá ter no máximo 100 caracteres")
	private String nomeFantasia;

	@Column(nullable = false)
	private EnderecoDTO endereco;

	private boolean ativo = true;

	public CentroDistribuicaoDTO() {
		super();
	}

	public CentroDistribuicaoDTO(Integer idCentroDistribuicao,
			@CNPJ @NotBlank(message = "CNPJ não informado") @Size(min = 14, max = 14, message = "O CNPJ deverá ter 14 caracteres(Sem traços, pontos e barras)") String cnpj,
			@NotBlank(message = "Razão Social não informada") @Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula") @Size(max = 100, message = "A Razão Social deverá ter no máximo 100 caracteres") String razaoSocial,
			String nomeFantasia, EnderecoDTO endereco, boolean ativo) {
		super();
		this.idCentroDistribuicao = idCentroDistribuicao;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
		this.ativo = ativo;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public Integer getIdCentroDistribuicao() {
		return idCentroDistribuicao;
	}

	public void setIdCentroDistribuicao(Integer idCentroDistribuicao) {
		this.idCentroDistribuicao = idCentroDistribuicao;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
