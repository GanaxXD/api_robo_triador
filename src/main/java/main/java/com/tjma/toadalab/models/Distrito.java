package main.java.com.tjma.toadalab.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity(name = "distritos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Distrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_distrito")
	private String nomeDistrito;

	@Column(name = "cod_normal")
	private String codNormal;

	@Column(name = "cod_urgente")
	private String codUrgente;


}
