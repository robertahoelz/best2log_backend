package com.best2log.best2log.model.dto;

public class RedefinirSenhaDTO {

	String email;

	String novaSenha;

	String codigo;

	public RedefinirSenhaDTO() {
	}

	public RedefinirSenhaDTO(String email, String novaSenha, String codigo) {
		super();
		this.email = email;
		this.novaSenha = novaSenha;
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
