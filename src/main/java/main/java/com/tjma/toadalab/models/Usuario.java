package main.java.com.tjma.toadalab.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * Classe que representa as credenciais de acesso do usuário
 * para o modelo Basic V1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Usuario {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String login;
	private String senha;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
