package main.java.com.tjma.toadalab.Models;

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

@Entity
public class Mandado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero_processo")
	private String numeroProcesso;
	
	@Column(name = "codigo_mandado")
	private String codigoMandado;
	
	@ManyToOne
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@Column(name = "data_distribuicao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDistribuicao;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public String getCodigoMandado() {
		return codigoMandado;
	}

	public void setCodigoMandado(String codigoMandado) {
		this.codigoMandado = codigoMandado;
	}

	@Override
	public String toString() {
		return "Mandado [id=" + id + ", numeroProcesso=" + numeroProcesso + ", codigoMandado=" + codigoMandado
				+ "]";
	}

	public Mandado() {
	}
	
	
}
