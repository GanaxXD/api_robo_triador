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
	
	@Column(name="hora_inicial_execucao_robo")
	private String horaInicialExecucaoRobo;
	
	@Column(name="minutas_inseridas")
	private int minutasInseridas;
	
	@ManyToOne
	@JoinColumn(name="robo_id", referencedColumnName = "id", nullable = false)
	private Robo robo_id;
	
	public int getMinutasInseridas() {
		return minutasInseridas;
	}

	public void setMinutasInseridas(int minutasInseridas) {
		this.minutasInseridas = minutasInseridas;
	}

	public Robo getRobo_id() {
		return robo_id;
	}

	public void setRobo_id(Robo robo_id) {
		this.robo_id = robo_id;
	}

	public String getHoraInicialExecucaoRobo() {
		return horaInicialExecucaoRobo;
	}

	public void setHoraInicialExecucaoRobo(String horaInicialExecucaoRobo) {
		this.horaInicialExecucaoRobo = horaInicialExecucaoRobo;
	}

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
		return robo_id;
	}

	public void setRobo(Robo robo) {
		this.robo_id = robo;
	}

	@Override
	public String toString() {
		return "Execucao [id=" + id + ", tempoEtiquetandoProcessos=" + tempoEtiquetandoProcessos
				+ ", quantidadeProcessosEtiquetados=" + quantidadeProcessosEtiquetados
				+ ", quantidadeEtiquetasInseridas=" + quantidadeEtiquetasInseridas + ", rodouEm=" + rodouEm
				+ ", qtdProcessosLidos=" + qtdProcessosLidos + ", houveErro=" + houveErro + ", horaInicialExecucaoRobo="
				+ horaInicialExecucaoRobo + ", minutasInseridas=" + minutasInseridas + ", robo_id=" + robo_id + "]";
	}
	
		
}

