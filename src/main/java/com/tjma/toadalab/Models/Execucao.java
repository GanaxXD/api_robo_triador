package main.java.com.tjma.toadalab.Models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "execucoes")
public class Execucao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/*
	 * @Column(name = "tempo_etiquetando_processos") private String
	 * tempoEtiquetandoProcessos;
	 */
	@Column(name = "tempo_etiquetando_processos")
	private LocalTime tempoEtiquetandoProcessos;
	
	@Column(name = "quantidade_processos_etiquetados")
	private int quantidadeProcessosEtiquetados;
	
	@Column(name = "quantidade_etiquetas_inseridas")
	private int quantidadeEtiquetasInseridas;
	
	@Column(name = "rodou_em")
	private LocalDate rodouEm;
	
	@Column(name = "quantidade_processos_lidos")
	private int qtdProcessosLidos;
	
	@Column(name="houve_erro")
	private boolean houveErro;
	
	@ManyToOne
	@JoinColumn(name="robo_id", referencedColumnName = "id", nullable = false)
	private Robo robo;
	
	public int getQuantidadeEtiquetasInseridas() {
		return quantidadeEtiquetasInseridas;
	}

	public void setQuantidadeEtiquetasInseridas(int quantidadeEtiquetasInseridas) {
		this.quantidadeEtiquetasInseridas = quantidadeEtiquetasInseridas;
	}

	public Long getId() {
		return id;
	}

	public boolean isHouveErro() {
		return houveErro;
	}

	public void setHouveErro(boolean houveErro) {
		this.houveErro = houveErro;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getTempoEtiquetandoProcessos() {
		return tempoEtiquetandoProcessos;
	}

	public void setTempoEtiquetandoProcessos(LocalTime tempoEtiquetandoProcessos) {
		this.tempoEtiquetandoProcessos = tempoEtiquetandoProcessos;
	}

	public int getQtdProcessosLidos() {
		return qtdProcessosLidos;
	}

	public void setQtdProcessosLidos(int qtdProcessosLidos) {
		this.qtdProcessosLidos = qtdProcessosLidos;
	}

	/*
	 * public String getTempoEtiquetandoProcessos() { return
	 * tempoEtiquetandoProcessos; }
	 * 
	 * public void setTempoEtiquetandoProcessos(String tempoEtiquetandoProcessos) {
	 * this.tempoEtiquetandoProcessos = tempoEtiquetandoProcessos; }
	 */
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
	/*
	 * public boolean isEncontrouErro() { return encontrouErro; }
	 * 
	 * public void setEncontrouErro(boolean encontrouErro) { this.encontrouErro =
	 * encontrouErro; }
	 */

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
				+ ", robo=" + robo + "]";
	}
	
	
}

