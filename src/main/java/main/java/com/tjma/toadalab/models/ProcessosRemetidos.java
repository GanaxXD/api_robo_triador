package main.java.com.tjma.toadalab.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "processos_remetidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ProcessosRemetidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="quantidade_processos_remetidos")
	private int quantidadeProcessosRemetidos;
	
	@Column(name="data_execucao")
	private LocalDateTime dataExecucao;
	
	@ManyToOne
	@JoinColumn(name = "robo_id", referencedColumnName = "id", nullable = false)
	private Robo robo_id;
}
