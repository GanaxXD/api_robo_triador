package main.java.com.tjma.toadalab.models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "interacoes_usuarios")
@EqualsAndHashCode
public class InteracoesUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "quantidade_click")
	private int quantidadeClick;
	@ManyToOne
	@JoinColumn(name = "id_robo")
	private Robo roboId;
	@Column(name = "data_de_execucao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeExecucao;
	@Column(name="quantidade_caracteres_digitados")
	private int quantidadeCaracteresDigitados;
	@Column(name="quantidade_palavras_digitadas")
	private int quantidadePalavrasDigitadas;
	@Column(name="quantidade_caracteres_lidos")
	private int quantidadeCaracteresLidos;
	@Column(name="quantidade_palavras_lidas")
	private int quantidadePalavrasLidas;
	
}
