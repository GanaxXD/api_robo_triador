package main.java.com.tjma.toadalab.Models;

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

@Entity(name = "distritos")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

	@OneToMany(mappedBy = "distrito")
	private List<Mandado> mandados;

	@Override
	public String toString() {
		return "Distrito [id=" + id + ", nomeDistrito=" + nomeDistrito + ", codNormal=" + codNormal + ", codUrgente="
				+ codUrgente + ", mandados=" + mandados + "]";
	}
}
