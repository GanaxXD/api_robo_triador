package main.java.com.tjma.toadalab.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "execucao_mario_lucio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExecucaoMarioLucio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tempo_distribuindo_mandados", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime tempoDistribuindoMandados;

	@Column(name = "quantidade_mandados_enviados", nullable = false)
	private int quantidadeMandadosEnviados;

	@Column(name = "quantidade_mandados_enviados_analise", nullable = false)
	private int quantidadeMandadosEnviadosParaAnalise;

	@Column(name = "rodou_em")
	private LocalDate rodouEm;

	@Column(name = "houve_erro")
	private boolean houveErro;

	@Column(name = "hora_inicial_execucao_robo", nullable = false)
	private String horaInicialExecucaoRobo;

	@ManyToOne
	@JoinColumn(name = "robo_id", referencedColumnName = "id", nullable = false)
	private Robo robo;

}
