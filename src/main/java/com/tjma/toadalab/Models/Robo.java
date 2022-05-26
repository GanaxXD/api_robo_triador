package main.java.com.tjma.toadalab.Models;

import java.time.LocalDate;


import lombok.Data;

@Data
public class Robo {
	
	private Long id;
	private String tipo;
	private String localImplantado;
	private LocalDate instaladoEm;
	private int quantidadeVezesRodou;

}
