package main.java.com.tjma.toadalab.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	@Column(name = "codigo")
	private String codigo;


}
