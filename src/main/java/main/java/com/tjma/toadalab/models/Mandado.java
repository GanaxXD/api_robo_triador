package main.java.com.tjma.toadalab.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity(name = "mandados")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Mandado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_processo")
	private String numeroProcesso;

	@Column(name = "codigo_mandado")
	private String codigoMandado;

	@Column(name = "id_documento")
	private String idDocumento;

	@ManyToOne
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;

	@Column(name = "data_distribuicao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDistribuicao;

}