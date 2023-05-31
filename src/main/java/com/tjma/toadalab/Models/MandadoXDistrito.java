package main.java.com.tjma.toadalab.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MandadoXDistrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate dataEnvio;
	private LocalDate horaEnvio;
	
	@OneToOne
	private Mandado mandadoId;
	@OneToOne
	private Distrito distritoId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public LocalDate getHoraEnvio() {
		return horaEnvio;
	}
	public void setHoraEnvio(LocalDate horaEnvio) {
		this.horaEnvio = horaEnvio;
	}
	public Mandado getMandadoId() {
		return mandadoId;
	}
	public void setMandadoId(Mandado mandadoId) {
		this.mandadoId = mandadoId;
	}
	public Distrito getDistritoId() {
		return distritoId;
	}
	public void setDistritoId(Distrito distritoId) {
		this.distritoId = distritoId;
	}
	@Override
	public String toString() {
		return "MandadoXDistrito [id=" + id + ", dataEnvio=" + dataEnvio + ", horaEnvio=" + horaEnvio + ", mandadoId="
				+ mandadoId + ", distritoId=" + distritoId + "]";
	}
	public MandadoXDistrito() {
	}
	
	
}
