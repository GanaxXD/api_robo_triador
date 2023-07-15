package main.java.com.tjma.toadalab.Controllers;

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

import main.java.com.tjma.toadalab.Models.Distrito;
import main.java.com.tjma.toadalab.Repositories.DistritoRepository;
import main.java.com.tjma.toadalab.Services.Validador;

@RestController
@RequestMapping(value = "/distritos", produces = "application/json")
@CrossOrigin(origins = "*")
public class DistritoController {

	@Autowired
	private DistritoRepository executeRepository;

	private Validador validador = new Validador();

	@GetMapping
	public List<Distrito> listar() {
		return executeRepository.findAll();
	}

	@GetMapping("/{executeId}")
	public ResponseEntity<Distrito> buscar(@PathVariable Long executeId) {
		Optional<Distrito> distritoDoBanco = executeRepository.findById(executeId);

		// O código de resposta da requisão não pode ser 200 caso seja nulo o cliente,
		// logo...
		if (distritoDoBanco.isPresent()) {
			// retorna o código 200 pra requisição
			return ResponseEntity.ok(distritoDoBanco.get());
		}

		return ResponseEntity.notFound().build(); // build ao fim para construir o response entity do tipo informado na
													// assinatura.
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
	public ResponseEntity<String> criar(@RequestBody Distrito distrito) {
		Distrito distritoDoBanco = executeRepository.findByCodNormal(distrito.getCodNormal()).orElse(null);
		if (distritoDoBanco != null) {
			System.out.println("O distrito não é válido!");
			return ResponseEntity.badRequest()
					.body("{Distrito com código Normal já cadastrado no banco: " + distritoDoBanco.toString() + "}");
		}

		/*
		 * if(validador.validarDistrito(distrito) == false) { System.out.
		 * println("Distrito com código normal, urgente ou nome já existente no banco."
		 * ); return ResponseEntity.badRequest().build(); }
		 */
		executeRepository.save(distrito);
		return ResponseEntity.ok(distrito.toString());
	}

	@PutMapping("/{executeId}")
	public ResponseEntity<Distrito> atualizar(@PathVariable Long executeId, @RequestBody Distrito distrito) {
		Optional<Distrito> distritoDoBanco = executeRepository.findById(executeId);

		if (distritoDoBanco.isPresent()) {
			distrito.setId(executeId);
			return ResponseEntity.ok(executeRepository.save(distrito));
		}

		return ResponseEntity.notFound().build(); // build ao fim para construir o response entity do tipo informado na
													// assinatura.
	}

	@DeleteMapping("/{executeId}")
	public ResponseEntity<Distrito> deletar(@PathVariable Long executeId) {
		Optional<Distrito> distritoDoBanco = executeRepository.findById(executeId);
		if (distritoDoBanco.isPresent()) {
			executeRepository.delete(distritoDoBanco.get());
			return ResponseEntity.noContent().build();
		}
		System.out.println("Distrito não encontrado!");
		return ResponseEntity.notFound().build(); // build ao fim para construir o response entity do tipo informado na
													// assinatura.
	}
}
