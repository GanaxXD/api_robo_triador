package main.java.com.tjma.toadalab.Models;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Execucao {
	private Long id;
	private String tempoEtiquetandoProcessos;
	private int quantidadeProcessosEtiquetados;
	private LocalDate rodouEm;
	private boolean encontrouErro;
	private Robo robo;
}

