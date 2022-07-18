package com.best2log.best2log.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "empresa")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEmpresa")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa")
	private Integer idEmpresa;

	@CNPJ
	@Column(name = "cnpj",unique=true)
	private String cnpj;

	@Column(name = "razao_social",unique=true)
	private String razaoSocial;

	@Column(name = "nome_fantasia",unique=true)
	private String nomeFantasia;

	@Column(name = "dt_cadastro")
	private LocalDate dataCadastro;

	private boolean ativo = true;

	@OneToMany(mappedBy = "empresa")
	private List<Pacote> pacotes;

	@OneToOne
	private Endereco endereco;

	
	
	

	public Empresa(Integer idEmpresa, @CNPJ String cnpj, String razaoSocial, String nomeFantasia,
			LocalDate dataCadastro, boolean ativo, List<Pacote> pacotes, Endereco endereco) {
		super();
		this.idEmpresa = idEmpresa;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
		this.pacotes = pacotes;
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Empresa() {
		super();
	}

	public Empresa(Integer idEmpresa, String cnpj, String razaoSocial, String nomeFantasia, LocalDate dataCadastro,
			boolean ativo, List<Pacote> pacotes) {
		super();
		this.idEmpresa = idEmpresa;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
		this.pacotes = pacotes;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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

}
