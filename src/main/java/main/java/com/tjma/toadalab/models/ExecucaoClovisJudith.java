package main.java.com.tjma.toadalab.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "execucoes_clovis_judith")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExecucaoClovisJudith {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/*
	 * @Column(name = "tempo_etiquetando_processos") private String
	 * tempoEtiquetandoProcessos;
	 */
	@Column(name = "tempo_etiquetando_processos")
	private LocalTime tempoEtiquetandoProcessos;

	@Column(name = "quantidade_processos_etiquetados", nullable = false)
	private int quantidadeProcessosEtiquetados;

	@Column(name = "quantidade_etiquetas_inseridas")
	private int quantidadeEtiquetasInseridas;

	@Column(name = "rodou_em")
	private LocalDate rodouEm;

	@Column(name = "quantidade_processos_lidos")
	private int qtdProcessosLidos;

	@Column(name = "houve_erro")
	private boolean houveErro;

	@Column(name = "hora_inicial_execucao_robo", nullable = false)
	private String horaInicialExecucaoRobo;

	@Column(name = "minutas_inseridas")
	private int minutasInseridas;

	@ManyToOne
	@JoinColumn(name = "robo_id", referencedColumnName = "id", nullable = false)
	private Robo robo_id;


	public boolean validarDadosDa(ExecucaoClovisJudith ex) {
		if (ex == null || ex.getRobo_id().getId() == null || ex.getHoraInicialExecucaoRobo() == null
				|| ex.getHoraInicialExecucaoRobo().isBlank() || ex.getHoraInicialExecucaoRobo().isEmpty()) {
			return false;
		}
		return true;
	}

}
