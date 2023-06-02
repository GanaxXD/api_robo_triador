package main.java.com.tjma.toadalab.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Distrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_distrito")
	private String nomeDistrito;
	
	@Column(name = "cod_normal")
	private String codNormal;
	
	@Column(name = "cod_urgente")
	private String codUrgente;	
	
	@OneToMany(mappedBy = "distrito")
    private List<Mandado> mandados;
	
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
