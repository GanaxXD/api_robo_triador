package main.java.com.tjma.toadalab.services;

import java.util.List;
import java.util.Optional;


import main.java.com.tjma.toadalab.models.Distrito;
import main.java.com.tjma.toadalab.models.ExecucaoClovisJudith;
import main.java.com.tjma.toadalab.models.ExecucaoMarioLucio;
import main.java.com.tjma.toadalab.models.Mandado;
import main.java.com.tjma.toadalab.models.Robo;
import main.java.com.tjma.toadalab.repositories.DistritoRepository;
import main.java.com.tjma.toadalab.repositories.RobosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Validador {

	@Autowired
	private DistritoRepository distritoRepo;

	@Autowired
	private RobosRepository roboRepository;

	public Validador() {
	}

	public boolean validarDistritoPeloCodigo(Distrito distrito) {
		if (distrito != null) {
			Optional<Distrito> distritoDoBanco = distritoRepo.findById(distrito.getId());
			if (ehUnicoPeloNome(distritoDoBanco.get()) && ehUnicoPeloCodigo(distritoDoBanco.get())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validarDistrito(Distrito dados) {
		if((dados.getCodigo() != null && dados.getCodigo().trim() != "") &&(dados.getNomeDistrito().trim() != null && dados.getNomeDistrito().trim() != "")) {
			return true;
		}
		return false;
	}

	public boolean ehUnicoPeloNome(Distrito distrito) {
		Distrito d = distritoRepo.findByNomeDistrito(distrito.getNomeDistrito()).orElse(null);
		if (d == null) {
			return true;
		}
		return false;
	}

	public boolean ehUnicoPeloCodigo(Distrito distrito) {
		Distrito codigo = distritoRepo.findByCodigo(distrito.getCodigo()).orElse(null);
		if (codigo == null) {
			return true;
		}
		return false;
	}

	/**
	 * Retorna true para um robô válido que atenda a regra de negócio: Robôs não
	 * podem ter nomes iguais.
	 *
	 * @author Pedro Dantas ToadaLab
	 * 
	 * @return true para um robô válido para ser guardado na base de dados
	 *
	 */
	public boolean validarRoboDoBanco(Robo robo) {
		Optional<Robo> r = roboRepository.findByNomeRobo(robo.getNomeRobo());
		if (r.isPresent()) {
			return false;
		}

		return true;
	}
	
	public boolean validarRobo(Robo robo) {
		if(robo.getInstaladoEm() != null
			&& (robo.getLocalImplantado() != null || robo.getLocalImplantado().trim() != "")
			&& (robo.getNomeRobo() != null || robo.getNomeRobo().trim() != "")
			&& (robo.getTipo() != null || robo.getTipo() != "")) {
			return true;
		}
		return false;
	}

	public boolean validarMandado(Mandado dados) {
		if((dados.getCodigoMandado() != null || dados.getCodigoMandado().trim() != "")
			&& (dados.getDataDistribuicao() != null) 
			&& (dados.getDistrito() != null)
			&& (dados.getIdDocumento() != null || dados.getIdDocumento().trim() != "")
			&& (dados.getNumeroProcesso() != null || dados.getNumeroProcesso().trim() != "")) {
			return true;
		}
		return false;
	}
	
	public boolean validarListaMandado(List<Mandado> listaDados) {
		boolean resultadoAtual = true;
		for(Mandado dados : listaDados) {
			if(validarMandado(dados)) {
				
			}else {
				break;
			}
		}
		return resultadoAtual == true ? true : false;
	}
	
	public boolean validarExecucaoMarioLucio(ExecucaoMarioLucio dados) {
		if((dados.getTempoDistribuindoMandados() != null)
			&& (this.validarRobo(dados.getRobo()))
			&& (dados.getQuantidadeMandadosEnviados()>=0 )
			&& (dados.getQuantidadeMandadosEnviadosParaAnalise()>=0 )
			&& (dados.getHoraInicialExecucaoRobo() != null || dados.getHoraInicialExecucaoRobo().trim() != "")) {
			return true;
		}
		return false;
	}

	public boolean validarExecucaoClovisJudith(ExecucaoClovisJudith execucaoClovisJudith) {
		if((execucaoClovisJudith.getHoraInicialExecucaoRobo() != null && execucaoClovisJudith.getHoraInicialExecucaoRobo().trim() != "")
			&& (execucaoClovisJudith.getQuantidadeProcessosEtiquetados() >=0)
			&& (validarRobo(execucaoClovisJudith.getRobo_id()))) {
			return true;
		}
		return false;
	}
	
	
}
