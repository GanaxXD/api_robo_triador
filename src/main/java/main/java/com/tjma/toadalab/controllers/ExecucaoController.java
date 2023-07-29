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
import main.java.com.tjma.toadalab.repositories.ExecucaoMandadosRepository;
import main.java.com.tjma.toadalab.repositories.ExecucaoRepository;
import main.java.com.tjma.toadalab.repositories.RobosRepository;

@RestController
@RequestMapping(value = "/execucoes", produces = "application/json")
@CrossOrigin(origins = "*")
public class ExecucaoController {

	@Autowired
	private ExecucaoRepository executeRepository;

	@Autowired
	private ExecucaoMandadosRepository executeMandRepository;

	@Autowired
	private RobosRepository robosRepository;

	@GetMapping
	public List<ExecucaoClovisJudith> listar() {
		return executeRepository.findAll();
	}

	@GetMapping("/mandados")
	public List<ExecucaoMarioLucio> listarMandados() {
		return executeMandRepository.findAll();
	}

	@GetMapping("/{executeId}")
	public ResponseEntity<ExecucaoClovisJudith> buscar(@PathVariable Long executeId) {
		Optional<ExecucaoClovisJudith> execucaoClovisJudith = executeRepository.findById(executeId);

		// O código de resposta da requisão não pode ser 200 caso seja nulo o cliente,
		// logo...
		if (execucaoClovisJudith.isPresent()) {
			// retorna o código 200 pra requisição
			return ResponseEntity.ok(execucaoClovisJudith.get());
		}

		return ResponseEntity.notFound().build(); // build ao fim para construir o response entity do tipo informado na
													// assinatura.
	}

	@GetMapping("/mandados/{executeId}")
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
	public ResponseEntity<ExecucaoClovisJudith> criar(@RequestBody ExecucaoClovisJudith execucaoClovisJudith) {
		Robo robo = robosRepository.findById(execucaoClovisJudith.getRobo_id().getId()).orElse(null);
		if (robo == null) {
			System.out.println(
					"O robô de código " + execucaoClovisJudith.getRobo_id().getId() + " não foi encontrado no banco de dados.");
			return ResponseEntity.notFound().build();
		}
		execucaoClovisJudith.setRobo_id(robo);
		execucaoClovisJudith.setRodouEm(LocalDate.now());
		ExecucaoClovisJudith ex = executeRepository.save(execucaoClovisJudith);
		return ex == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok().build();
	}

	@PostMapping("/mandados")
	@ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
	public ResponseEntity<ExecucaoMarioLucio> criarMandado(@RequestBody ExecucaoMarioLucio execucao) {
		System.out.println(execucao);
		Robo robo = robosRepository.findById(execucao.getRobo().getId()).get();
		if (robo == null) {
			System.out.println(
					"O robô de código " + execucao.getRobo().getId() + " não foi encontrado no banco de dados.");
			return ResponseEntity.notFound().build();
		}
		execucao.setRobo(robo);
		execucao.setRodouEm(LocalDate.now());
		ExecucaoMarioLucio ex = executeMandRepository.save(execucao);
		return ex == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok().build();
	}

	@PutMapping("/{executeId}")
	public ResponseEntity<ExecucaoClovisJudith> atualizar(@RequestBody ExecucaoClovisJudith execucaoClovisJudith, @PathVariable Long executeId) {
		if (!executeRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}

		execucaoClovisJudith.setId(executeId);
		return ResponseEntity.ok(executeRepository.save(execucaoClovisJudith));
	}

	@PutMapping("/mandados/{executeId}")
	public ResponseEntity<ExecucaoMarioLucio> atualizarMandado(@RequestBody ExecucaoMarioLucio execucao,
			@PathVariable Long executeId) {
		if (!executeMandRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}

		execucao.setId(executeId);
		return ResponseEntity.ok(executeMandRepository.save(execucao));
	}

	@DeleteMapping("/{executeId}")
	public ResponseEntity<Void> deletar(@PathVariable Long executeId) {
		if (!executeRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}
		// clientInterface.deletar(clientInterface.findById(clientId).get());
		executeRepository.delete(executeRepository.findById(executeId).get());
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/mandados/{executeId}")
	public ResponseEntity<Void> deletarMandado(@PathVariable Long executeId) {
		if (!executeMandRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}
		// clientInterface.deletar(clientInterface.findById(clientId).get());
		executeMandRepository.delete(executeMandRepository.findById(executeId).get());
		return ResponseEntity.noContent().build();
	}

	@Override
	public String toString() {
		return "ExecucaoController [executeRepository=" + executeRepository + ", executeMandRepository="
				+ executeMandRepository + ", robosRepository=" + robosRepository + "]";
	}
}
