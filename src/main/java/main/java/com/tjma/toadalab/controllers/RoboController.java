package main.java.com.tjma.toadalab.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.tjma.toadalab.dtos.RoboRecordDTO;
import main.java.com.tjma.toadalab.models.Robo;
import main.java.com.tjma.toadalab.repositories.RobosRepository;
import main.java.com.tjma.toadalab.services.Validador;

@RestController
@RequestMapping(value = "/robos", produces = "application/json")
@CrossOrigin(origins = "*")
public class RoboController {

	@Autowired
	private RobosRepository roboRepository;

	//@Autowired
	//private CacheManager cacheManager;

	private Validador validador = new Validador();

	@GetMapping()
	public List<Robo> listar() {
		return roboRepository.findAll();
	}

	@GetMapping("/{roboId}")
	public ResponseEntity<Robo> buscarpeloId(@PathVariable Long roboId) {
		Optional<Robo> robo = roboRepository.findById(roboId);

		// O código de resposta da requisão não pode ser 200 caso seja nulo o cliente,
		// logo...
		if (robo.isPresent()) {
			// retorna o código 200 pra requisição
			return ResponseEntity.ok(robo.get());
		}

		return ResponseEntity.notFound().build(); // build ao fim para construir o response entity do tipo informado na
													// assinatura.
	}

	@GetMapping("/buscar/{numeroRobo}")
	public ResponseEntity<Robo> buscarpeloNome(@PathVariable String numeroRobo) {

		// Passando acentos pela URL, o decodificador está encontrando erros na
		// conversão (RFC 7230 e RFC 3986)
		String roboName = "ToadaRobô" + numeroRobo;

		List<Robo> robo = roboRepository.findByNomeRoboContains(roboName);

		if (!robo.isEmpty()) {
			return ResponseEntity.ok(robo.get(0));
		}

		return ResponseEntity.notFound().build(); // build ao fim para construir o response entity do tipo informado na
													// assinatura.
	}

	@GetMapping("/buscar/processosparados/{numeroRobo}")
	public ResponseEntity<Robo> buscarProcessosParadosNome(@PathVariable String numeroRobo) {
		// Passando acentos pela URL, o decodificador está encontrando erros na
		// conversão (RFC 7230 e RFC 3986)
		String roboName = "ProcessosParados" + numeroRobo;

		List<Robo> robo = roboRepository.findByNomeRoboContains(roboName);

		// O código de resposta da requisão não pode ser 200 caso seja nulo o cliente,
		// logo...
		if (!robo.isEmpty()) {
			// retorna o código 200 pra requisição
			return ResponseEntity.ok(robo.get(0));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping(consumes = { "application/json", "application/text" })
	public ResponseEntity<Object> criar(@RequestBody @Valid RoboRecordDTO robo) {
		if (robo == null || roboRepository.findByNomeRobo(robo.nomeRobo()).isPresent() == true) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).eTag("Robo com nome ja cadastrado na base").body("Robô com nome já cadastrado na base");
		}
		Robo r = new Robo(); 
		BeanUtils.copyProperties(robo, r);
		return ResponseEntity.ok(roboRepository.save(r));
	}

	@PutMapping("/{roboId}")
	public ResponseEntity<Robo> atualizar(@Validated @RequestBody @Valid RoboRecordDTO robo, @PathVariable Long roboId) {
		Robo r = new Robo();
		if (!roboRepository.existsById(roboId)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).eTag("Robô inexistente na base de dados").body(null);
		}
		if (robo.instaladoEm() == null || robo.instaladoEm().equals("")) {
			r.setInstaladoEm(r.getInstaladoEm());
		}
		BeanUtils.copyProperties(robo, r);		
		r.setId(roboId);
		roboRepository.save(r);
		//cacheManager.getCache("lista_robos").clear();
		//cacheManager.getCache("robo_processos_parados").clear();
		return ResponseEntity.ok(r);
	}

	@DeleteMapping("/{roboId}")
	public ResponseEntity<Void> deletar(@PathVariable Long roboId) {
		if (!roboRepository.existsById(roboId)) {
			return ResponseEntity.notFound().build();
		}
		// clientInterface.deletar(clientInterface.findById(clientId).get());
		roboRepository.delete(roboRepository.findById(roboId).get());
		//cacheManager.getCache("robo_processos_parados").clear();
		return ResponseEntity.noContent().build();
	}
}
