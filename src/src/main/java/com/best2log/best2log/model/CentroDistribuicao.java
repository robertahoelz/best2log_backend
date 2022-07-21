package com.best2log.best2log.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "centro_distribuicao")
public class CentroDistribuicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_centro_distribuicao", nullable = false)
	private Integer idCentroDistribuicao;

	@Column(name = "cnpj", nullable = false, unique = true)
	private String cnpj;

	@Column(name = "razao_social", nullable = false, unique = true)
	private String razaoSocial;

	@Column(name = "nome_fantasia", nullable = false, unique = true)
	private String nomeFantasia;

	@OneToOne
	private Endereco endereco;

	private boolean ativo = true;

	@OneToMany(mappedBy = "cd")
	private List<Pacote> pacotes;

	public CentroDistribuicao() {
		super();
	}

	public CentroDistribuicao(Integer idCentroDistribuicao, String cnpj, String razaoSocial, String nomeFantasia,
			Endereco endereco, boolean ativo, List<Pacote> pacotes) {
		super();
		this.idCentroDistribuicao = idCentroDistribuicao;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
		this.ativo = ativo;
		this.pacotes = pacotes;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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

}
