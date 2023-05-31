package main.java.com.tjma.toadalab.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Distrito {
	
	private String nomeDistrito;
	
	private String codNormal;
	
	private String codUrgente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	public String getCodNormal() {
		return codNormal;
	}
	public void setCodNormal(String codNormal) {
		this.codNormal = codNormal;
	}
	public String getCodUrgente() {
		return codUrgente;
	}
	public void setCodUrgente(String codUrgente) {
		this.codUrgente = codUrgente;
	}
	public String getNomeDistrito() {
		return nomeDistrito;
	}
	public void setNomeDistrito(String nomeDistrito) {
		this.nomeDistrito = nomeDistrito;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Distrito() {
	}
	@Override
	public String toString() {
		return "Distrito [nomeDistrito=" + nomeDistrito + ", id=" + id + "]";
	}
	
}
