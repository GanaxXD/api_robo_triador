package com.tjma.toadalab.Models;


/*
 * Classe que representa as credenciais de acesso do usuário
 * para o modelo Basic V1
 */
public class Usuario{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String senha;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario() {
		super();
	}
	public Usuario(String id, String senha) {
		super();
		this.id = id;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", senha=" + senha + "]";
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
