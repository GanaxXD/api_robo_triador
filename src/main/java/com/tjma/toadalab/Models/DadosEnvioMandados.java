package main.java.com.tjma.toadalab.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "dados_envio_mandados")
public class DadosEnvioMandados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="quantidade_mandados_distrito_data_distribuicao_a")
	private String quantidadeMandadosDistritoDataDistribuicaoA;
	
	@Column(name="quantidade_mandados_distrito_data_distribuicao_b")
	private String quantidadeMandadosDistritoDataDistribuicaoB;
	
	@Column(name="data_criacao_no_banco")
	private String dataCriacaoNoBanco;
	
	@Column(name="distrito_mais_mandados_enviados")
	private String distritoMaisMandadosEnviados;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuantidadeMandadosDistritoDataDistribuicaoA() {
		return quantidadeMandadosDistritoDataDistribuicaoA;
	}

	public void setQuantidadeMandadosDistritoDataDistribuicaoA(String quantidadeMandadosDistritoDataDistribuicaoA) {
		this.quantidadeMandadosDistritoDataDistribuicaoA = quantidadeMandadosDistritoDataDistribuicaoA;
	}

	public String getQuantidadeMandadosDistritoDataDistribuicaoB() {
		return quantidadeMandadosDistritoDataDistribuicaoB;
	}

	public void setQuantidadeMandadosDistritoDataDistribuicaoB(String quantidadeMandadosDistritoDataDistribuicaoB) {
		this.quantidadeMandadosDistritoDataDistribuicaoB = quantidadeMandadosDistritoDataDistribuicaoB;
	}

	public String getDataCriacaoNoBanco() {
		return dataCriacaoNoBanco;
	}

	public void setDataCriacaoNoBanco(String dataCriacaoNoBanco) {
		this.dataCriacaoNoBanco = dataCriacaoNoBanco;
	}

	public String getDistritoMaisMandadosEnviados() {
		return distritoMaisMandadosEnviados;
	}

	public void setDistritoMaisMandadosEnviados(String distritoMaisMandadosEnviados) {
		this.distritoMaisMandadosEnviados = distritoMaisMandadosEnviados;
	}

	public DadosEnvioMandados(Long id, String quantidadeMandadosDistritoDataDistribuicaoA,
			String quantidadeMandadosDistritoDataDistribuicaoB, String dataCriacaoNoBanco,
			String distritoMaisMandadosEnviados) {
		super();
		this.id = id;
		this.quantidadeMandadosDistritoDataDistribuicaoA = quantidadeMandadosDistritoDataDistribuicaoA;
		this.quantidadeMandadosDistritoDataDistribuicaoB = quantidadeMandadosDistritoDataDistribuicaoB;
		this.dataCriacaoNoBanco = dataCriacaoNoBanco;
		this.distritoMaisMandadosEnviados = distritoMaisMandadosEnviados;
	}

	public DadosEnvioMandados() {
	}

	@Override
	public String toString() {
		return "DadosEnvioMandados [id=" + id + ", quantidadeMandadosDistritoDataDistribuicaoA="
				+ quantidadeMandadosDistritoDataDistribuicaoA + ", quantidadeMandadosDistritoDataDistribuicaoB="
				+ quantidadeMandadosDistritoDataDistribuicaoB + ", dataCriacaoNoBanco=" + dataCriacaoNoBanco
				+ ", distritoMaisMandadosEnviados=" + distritoMaisMandadosEnviados + "]";
	}

}
