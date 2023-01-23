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
@Entity(name = "execucao_mandados")
public class ExecucaoMandados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/*
	 * @Column(name = "tempo_etiquetando_processos") private String
	 * tempoEtiquetandoProcessos;
	 */
	@Column(name = "tempo_distribuindo_mandados")
	private LocalTime tempoDistribuindoMandados;
	
	
	@Column(name = "quantidade_mandados_enviados")
	private int quantidadeMandadosEnviados;
	
	@Column(name = "quantidade_mandados_enviados_analise")
	private int quantidadeMandadosEnviadosParaAnalise;
	
	@Column(name = "rodou_em")
	private LocalDate rodouEm;
		
	@Column(name="houve_erro")
	private boolean houveErro;
	
	@Column(name="hora_inicial_execucao_robo")
	private String horaInicialExecucaoRobo;
	
	@ManyToOne
	@JoinColumn(name="robo_id", referencedColumnName = "id", nullable = false)
	private Robo robo;
	
	
	public String getHoraInicialExecucaoRobo() {
		return horaInicialExecucaoRobo;
	}

	public LocalTime getTempoDistribuindoMandados() {
		return tempoDistribuindoMandados;
	}

	public void setTempoDistribuindoMandados(LocalTime tempoDistribuindoMandados) {
		this.tempoDistribuindoMandados = tempoDistribuindoMandados;
	}

	public int getQuantidadeMandadosEnviados() {
		return quantidadeMandadosEnviados;
	}

	public void setQuantidadeMandadosEnviados(int quantidadeMandadosEnviados) {
		this.quantidadeMandadosEnviados = quantidadeMandadosEnviados;
	}

	public int getQuantidadeMandadosEnviadosParaAnalise() {
		return quantidadeMandadosEnviadosParaAnalise;
	}

	public void setQuantidadeMandadosEnviadosParaAnalise(int quantidadeMandadosEnviadosParaAnalise) {
		this.quantidadeMandadosEnviadosParaAnalise = quantidadeMandadosEnviadosParaAnalise;
	}

	public void setHoraInicialExecucaoRobo(String horaInicialExecucaoRobo) {
		this.horaInicialExecucaoRobo = horaInicialExecucaoRobo;
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

	
	/*
	 * public String getTempoEtiquetandoProcessos() { return
	 * tempoEtiquetandoProcessos; }
	 * 
	 * public void setTempoEtiquetandoProcessos(String tempoEtiquetandoProcessos) {
	 * this.tempoEtiquetandoProcessos = tempoEtiquetandoProcessos; }
	 */
	
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
		return "ExecucaoMandados [id=" + id + ", tempoDistribuindoMandados=" + tempoDistribuindoMandados
				+ ", quantidadeMandadosEnviados=" + quantidadeMandadosEnviados
				+ ", quantidadeMandadosEnviadosParaAnalise=" + quantidadeMandadosEnviadosParaAnalise + ", rodouEm="
				+ rodouEm + ", houveErro=" + houveErro
				+ ", horaInicialExecucaoRobo=" + horaInicialExecucaoRobo + ", robo=" + robo + "]";
	}

	
	
}

