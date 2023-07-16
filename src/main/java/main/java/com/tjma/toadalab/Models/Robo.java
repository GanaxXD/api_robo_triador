package main.java.com.tjma.toadalab.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "robos")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	@Override
	public String toString() {
		return "Robo [id=" + id + ", tipo=" + tipo + ", localImplantado=" + localImplantado + ", instaladoEm="
				+ instaladoEm + "grau= "+grau+"]";
	}
}
