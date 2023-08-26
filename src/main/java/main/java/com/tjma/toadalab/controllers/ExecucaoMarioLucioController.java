package main.java.com.tjma.toadalab.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.tjma.toadalab.models.ExecucaoClovisJudith;
import main.java.com.tjma.toadalab.models.ExecucaoMarioLucio;
import main.java.com.tjma.toadalab.models.Robo;
import main.java.com.tjma.toadalab.repositories.ExecucaoMarioLucioRepository;
import main.java.com.tjma.toadalab.repositories.ExecucaoClovisJudithRepository;
import main.java.com.tjma.toadalab.repositories.RobosRepository;
import main.java.com.tjma.toadalab.services.Validador;

@RestController
@RequestMapping(value = "/execucoes/mandados", produces = "application/json")
@CrossOrigin(origins = "*")
public class ExecucaoMarioLucioController {


	@Autowired
	private ExecucaoMarioLucioRepository executeMandRepository;

	@Autowired
	private RobosRepository robosRepository;
	
	Validador validadorMarioLucio = new Validador();

	@GetMapping("")
	public List<ExecucaoMarioLucio> listarMandados() {
		return executeMandRepository.findAll();
	}

	@GetMapping("/{executeId}")
	public ResponseEntity<ExecucaoMarioLucio> buscarMandado(@PathVariable Long executeId) {
		Optional<ExecucaoMarioLucio> execucao = executeMandRepository.findById(executeId);

		// O código de resposta da requisão não pode ser 200 caso seja nulo o cliente,
		// logo...
		if (execucao.isPresent()) {
			// retorna o código 200 pra requisição
			return ResponseEntity.ok(execucao.get());
		}

		return ResponseEntity.notFound().build(); // build ao fim para construir o response entity do tipo informado na
													// assinatura.
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
	public ResponseEntity<ExecucaoMarioLucio> criarMandado(@RequestBody ExecucaoMarioLucio execucao) {
		Robo robo = robosRepository.findById(execucao.getRobo().getId()).get();
		if (robo == null) {
			System.err.println(
					"O robô de código " + execucao.getRobo().getId() + " não foi encontrado no banco de dados.");
			return ResponseEntity.notFound().build();
		}
		execucao.setRobo(robo);
		execucao.setRodouEm(LocalDate.now());
		ExecucaoMarioLucio ex = validadorMarioLucio.validarExecucaoMarioLucio(execucao) == true ? executeMandRepository.save(execucao) :null;
		return ex == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok().build();
	}

	@PutMapping("/{executeId}")
	public ResponseEntity<ExecucaoMarioLucio> atualizarMandado(@RequestBody ExecucaoMarioLucio execucao,
			@PathVariable Long executeId) {
		if (!executeMandRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}
		execucao.setId(executeId);
		return validadorMarioLucio.validarExecucaoMarioLucio(execucao) ? ResponseEntity.ok(executeMandRepository.save(execucao)) : ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/{executeId}")
	public ResponseEntity<Void> deletarMandado(@PathVariable Long executeId) {
		if (!executeMandRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}
		// clientInterface.deletar(clientInterface.findById(clientId).get());
		executeMandRepository.delete(executeMandRepository.findById(executeId).get());
		return ResponseEntity.noContent().build();
	}
}
