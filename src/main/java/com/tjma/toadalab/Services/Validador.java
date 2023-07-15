 package main.java.com.tjma.toadalab.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.tjma.toadalab.Models.Distrito;
import main.java.com.tjma.toadalab.Models.Robo;
import main.java.com.tjma.toadalab.Repositories.DistritoRepository;
import main.java.com.tjma.toadalab.Repositories.RobosRepository;

public class Validador {

	@Autowired
	private DistritoRepository distritoRepo;

	@Autowired
	private RobosRepository roboRepository;

	public Validador() {}

	public boolean validarDistrito(Distrito distrito) {
		if(distrito != null) {
			Optional<Distrito> distritoDoBanco = distritoRepo.findById(distrito.getId());
			if(ehUnicoPeloNome(distritoDoBanco.get()) && ehUnicoPeloCodigo(distritoDoBanco.get())) {
				return true;
			}
		}
		return false;
	}

	public boolean ehUnicoPeloNome(Distrito distrito) {
		Distrito d = distritoRepo.findByNomeDistrito(distrito.getNomeDistrito()).orElse(null);
		if(d == null) {
			return true;
		}
		return false;
	}

	public boolean ehUnicoPeloCodigo(Distrito distrito) {
		Distrito codNormal  = distritoRepo.findByCodNormal(distrito.getCodNormal()).orElse(null);
		Distrito codUrgente = distritoRepo.findByCodUrgente(distrito.getCodUrgente()).orElse(null);
		if(codNormal == null && codUrgente == null) {
			return true;
		}
		return false;
	}

	/*
	 * Retorna true para um robô válido que atenda a regra de negócio:
	 * Robôs não podem ter nomes iguais.
	 *
	 * @author Pedro Dantas ToadaLab
	 * @return true para um robô válido para ser guardado na base de dados
	 *
	 */
	public boolean validarRobo(Robo robo) {
		Optional<Robo> r = roboRepository.findByNomeRobo(robo.getNomeRobo());
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+roboRepository+"\n\n\n\n\n\n\n\n\n\n\n");
		if(r.isPresent()) {
			return false;
		}

		return true;
	}
}
