package main.java.com.tjma.toadalab.Models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;

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
}

