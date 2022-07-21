package com.best2log.best2log.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FuncionarioDTO {
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer idFuncionario;

	@NotBlank(message = "Nome não informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	@Size(max = 100, message = "O nome deverá ter no máximo 100 caracteres")
	private String nome;

	@CPF(message = "Número CPF inválido")
	@NotBlank(message = "CPF não informado")
	@Size(min = 11, max = 11, message = "O CPF deverá ter 14 caracteres (Sem traços, pontos, e barras)")
	private String cpf;

	@Email(message = "E-mail inválido")
	@NotBlank(message = "E-mail não informado")
	@Size(max = 100, message = "O email deverá ter no máximo 100 caracteres")
	private String email;

	@NotBlank(message = "Senha não informada")
	@Size(min = 8, message = "A senha deverá ter no mínimo 8 caracteres")
	private String senha;

	@NotNull(message = "Data de nascimento não informada. (Formatação: YYYY-MM-DD)")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@NotBlank(message = "Telefone não informado")
	@Size(min = 10, max = 11, message = "O telefone deverá ter entre 10 e 11 caracteres (Incluindo DDD, sem traços, pontos, barras, espaços em branco)")
	private String celular;

	@NotBlank(message = "Cargo não informado")
	@Size(max = 100, message = "O cargo deverá ter no máximo 100 caracteres")
	private String cargo;

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
