package main.java.com.tjma.toadalab.Models;

import org.springframework.security.core.GrantedAuthority;

public class Perfil implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String perfil;

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Perfil(String perfil) {
		super();
		this.perfil = perfil;
	}

	public Perfil() {
		super();
	}

	@Override
	public String getAuthority() {
		return this.perfil;
	}
	
}
