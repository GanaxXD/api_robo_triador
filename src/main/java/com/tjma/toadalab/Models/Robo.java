package main.java.com.tjma.toadalab.Models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity(name = "robos")
public class Robo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "local_implantado")
	private String localImplantado;
	
	@Column(name = "instalado_em")
	private LocalDate instaladoEm;
	
	@Column(name = "quantidade_vezes_rodou")
	private int quantidadeVezesRodou;
	

}
