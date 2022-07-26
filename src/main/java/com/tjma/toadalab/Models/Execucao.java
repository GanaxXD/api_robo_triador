package main.java.com.tjma.toadalab.Models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "execucoes")
public class Execucao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tempo_etiquetando_processos")
	private String tempoEtiquetandoProcessos;
	
	@Column(name = "quantidade_processos_etiquetados")
	private int quantidadeProcessosEtiquetados;
	
	@Column(name = "rodou_em")
	private LocalDate rodouEm;
	
	@Column(name = "encontrou_erro")
	private boolean encontrouErro;
	
	@ManyToOne
	private Robo robo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTempoEtiquetandoProcessos() {
		return tempoEtiquetandoProcessos;
	}

	public void setTempoEtiquetandoProcessos(String tempoEtiquetandoProcessos) {
		this.tempoEtiquetandoProcessos = tempoEtiquetandoProcessos;
	}

	public int getQuantidadeProcessosEtiquetados() {
		return quantidadeProcessosEtiquetados;
	}

	public void setQuantidadeProcessosEtiquetados(int quantidadeProcessosEtiquetados) {
		this.quantidadeProcessosEtiquetados = quantidadeProcessosEtiquetados;
	}

	public LocalDate getRodouEm() {
		return rodouEm;
	}

	public void setRodouEm(LocalDate rodouEm) {
		this.rodouEm = rodouEm;
	}

	public boolean isEncontrouErro() {
		return encontrouErro;
	}

	public void setEncontrouErro(boolean encontrouErro) {
		this.encontrouErro = encontrouErro;
	}

	public Robo getRobo() {
		return robo;
	}

	public void setRobo(Robo robo) {
		this.robo = robo;
	}

	@Override
	public String toString() {
		return "Execucao [id=" + id + ", tempoEtiquetandoProcessos=" + tempoEtiquetandoProcessos
				+ ", quantidadeProcessosEtiquetados=" + quantidadeProcessosEtiquetados + ", rodouEm=" + rodouEm
				+ ", encontrouErro=" + encontrouErro + ", robo=" + robo + "]";
	}
	
	
}

