package main.java.com.tjma.toadalab.Models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity(name = "robos")
public class Robo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "local_implantado")
	private String localImplantado;
	
	@Column(name = "instalado_em")
	private LocalDate instaladoEm;
	
	@Column(name = "quantidade_vezes_rodou")
	private int quantidadeVezesRodou;

	@Column(name = "nome_robo")
	private String nomeRobo;

	@Override
	public String toString() {
		return "Robo [id=" + id + ", tipo=" + tipo + ", localImplantado=" + localImplantado + ", instaladoEm="
				+ instaladoEm + ", quantidadeVezesRodou=" + quantidadeVezesRodou + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLocalImplantado() {
		return localImplantado;
	}

	public void setLocalImplantado(String localImplantado) {
		this.localImplantado = localImplantado;
	}

	public LocalDate getInstaladoEm() {
		return instaladoEm;
	}

	public void setInstaladoEm(LocalDate instaladoEm) {
		this.instaladoEm = instaladoEm;
	}

	public int getQuantidadeVezesRodou() {
		return quantidadeVezesRodou;
	}

	public void setQuantidadeVezesRodou(int quantidadeVezesRodou) {
		this.quantidadeVezesRodou = quantidadeVezesRodou;
	}

	public String getNomeRobo() {
		return nomeRobo;
	}

	public void setNomeRobo(String nomeRobo) {
		this.nomeRobo = nomeRobo;
	}
}
