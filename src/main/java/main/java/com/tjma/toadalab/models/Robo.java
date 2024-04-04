package main.java.com.tjma.toadalab.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
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
	
	@Column(name = "nome_robo", unique = true)
	private String nomeRobo;
	
	@Column(name = "grau")
	private String grau;

}
