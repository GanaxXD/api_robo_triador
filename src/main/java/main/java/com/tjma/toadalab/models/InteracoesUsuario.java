package main.java.com.tjma.toadalab.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
}
