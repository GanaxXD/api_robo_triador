package main.java.com.tjma.toadalab.controllers;

import java.time.LocalDateTime;
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

import main.java.com.tjma.toadalab.models.ProcessosRemetidos;
import main.java.com.tjma.toadalab.models.Robo;
import main.java.com.tjma.toadalab.repositories.ProcessosRemetidosRepository;
import main.java.com.tjma.toadalab.repositories.RobosRepository;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/processosremetidos",produces = "application/json")
public class ProcessosRemetidosController {
	@Autowired
	private ProcessosRemetidosRepository processosRepository;
	
	@Autowired
	private RobosRepository roboRepository;

	@GetMapping
	public List<ProcessosRemetidos> listar() {
		return processosRepository.findAll();
	}

	@GetMapping("/{executeId}")
	public ResponseEntity<ProcessosRemetidos> buscar(@PathVariable Long executeId) {
		Optional<ProcessosRemetidos> processoRemetido = processosRepository.findById(executeId);

		// O código de resposta da requisão não pode ser 200 caso seja nulo o cliente,
		// logo...
		if (processoRemetido.isPresent()) {
			// retorna o código 200 pra requisição
			return ResponseEntity.ok(processoRemetido.get());
		}

		return ResponseEntity.notFound().build(); // build ao fim para construir o response entity do tipo informado na
													// assinatura.
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
	public ResponseEntity<ProcessosRemetidos> criar(@RequestBody ProcessosRemetidos processoRemetido) {
		Robo robo = roboRepository.findById(processoRemetido.getRobo_id().getId()).orElse(null);
		if (robo == null) {
			System.err.println(
					"O robô de código " + processoRemetido.getRobo_id().getId() + " não foi encontrado no banco de dados.");
			return ResponseEntity.notFound().build();
		}
		processoRemetido.setRobo_id(robo);
		processoRemetido.setDataExecucao(LocalDateTime.now());
		return ResponseEntity.ok(processosRepository.save(processoRemetido));
	}

	@PutMapping("/{executeId}")
	public ResponseEntity<Object> atualizar(@RequestBody ProcessosRemetidos processo, @PathVariable Long executeId) {
		if (!processosRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}
		ProcessosRemetidos processoDoBanco = processosRepository.findById(executeId).orElse(null);
		if(processoDoBanco != null) {
			processo.setId(executeId);
			if (processo.getDataExecucao() == null) processo.setDataExecucao(processoDoBanco.getDataExecucao());
			if (processo.getQuantidadeProcessosRemetidos() == 0) processo.setQuantidadeProcessosRemetidos(processoDoBanco.getQuantidadeProcessosRemetidos());
			if(processo.getRobo_id() == null) {
				processo.setRobo_id(processoDoBanco.getRobo_id());
			}else{
				if(roboRepository.existsById(processo.getRobo_id().getId())) {
					return ResponseEntity.badRequest().body("O-robo-nao-existe.");
				}
			}
			return ResponseEntity.ok(processosRepository.save(processo));
		}else {
			return ResponseEntity.badRequest().body("Os-dados-passados-estao-incorretos.");
		}
	}


	@DeleteMapping("/{executeId}")
	public ResponseEntity<Void> deletar(@PathVariable Long executeId) {
		if (!processosRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}
		// clientInterface.deletar(clientInterface.findById(clientId).get());
		processosRepository.delete(processosRepository.findById(executeId).get());
		return ResponseEntity.noContent().build();
	}
}
