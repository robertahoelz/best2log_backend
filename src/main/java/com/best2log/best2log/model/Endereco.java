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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "endereco")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEndereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer idEndereco;
	
	@Column(name = "cep", nullable = false,length=8)
	private String cep;
	
	@Column(name = "rua", nullable = false)
	private String rua;

	@Column(name = "bairro", nullable = false)
	private String bairro;

	@Column(name = "cidade", nullable = false)
	private String cidade;

	@Column(name = "numero", nullable = false)
	private Integer numeroEndereco;

	@Column(name = "complemento", nullable = false)
	private String complemento;

	@Column(name = "uf", nullable = false)
	private String uf;

	@OneToMany(mappedBy = "endereco")
	private List<Pacote> pacotes;

	@OneToOne
	private CentroDistribuicao cd;

	@OneToOne
	private Empresa empresa;
	
	

	public Endereco(Integer idEndereco, String cep, String rua, String bairro, String cidade, Integer numeroEndereco,
			String complemento, String uf, List<Pacote> pacotes, CentroDistribuicao cd, Empresa empresa) {
		super();
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numeroEndereco = numeroEndereco;
		this.complemento = complemento;
		this.uf = uf;
		this.pacotes = pacotes;
		this.cd = cd;
		this.empresa = empresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Endereco() {
		super();
	}

	

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}

	public CentroDistribuicao getCd() {
		return cd;
	}

	public void setCd(CentroDistribuicao cd) {
		this.cd = cd;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Integer numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
