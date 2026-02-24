package com.luan.apiusuarios.dto;

import jakarta.validation.constraints.Email;

public class UserPatchDTO {
	private String nome;
	
	@Email(message = "Email inválido")
	private String email;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
