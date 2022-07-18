package com.best2log.best2log.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Table(name = "pacote")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pacote")
@Entity
public class Pacote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pacote")
	private Integer idPacote;

	@Column(name = "status_pacote")
	private String statusPacote;

	@Column(name = "dt_entrada")
	private LocalDate dataEntrada;

	@Column(name = "cep")
	private String cep;

	@ManyToOne
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;

	@ManyToOne
	private Empresa empresa;

	@ManyToOne
	private CentroDistribuicao cd;
	
	private boolean lixeira=false;

	
	
	public boolean isLixeira() {
		return lixeira;
	}

	public void setLixeira(boolean lixeira) {
		this.lixeira = lixeira;
	}

	public Pacote() {
		super();
	}

	public Pacote(Integer idPacote, String statusPacote, LocalDate dataEntrada, String cep, Endereco endereco,
			Empresa empresa, CentroDistribuicao cd) {
		super();
		this.idPacote = idPacote;
		this.statusPacote = statusPacote;
		this.dataEntrada = dataEntrada;
		this.cep = cep;
		this.endereco = endereco;
		this.empresa = empresa;
		this.cd = cd;
	}

	public CentroDistribuicao getCd() {
		return cd;
	}

	public void setCd(CentroDistribuicao cd) {
		this.cd = cd;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
