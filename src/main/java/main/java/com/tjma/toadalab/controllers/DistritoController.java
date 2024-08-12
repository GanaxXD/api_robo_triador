package main.java.com.tjma.toadalab.controllers;

import java.util.List;
import java.util.Optional;

import main.java.com.tjma.toadalab.services.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.tjma.toadalab.dtos.DistritoRecordDTO;
import main.java.com.tjma.toadalab.models.Distrito;
import main.java.com.tjma.toadalab.repositories.DistritoRepository;
import main.java.com.tjma.toadalab.services.Validador;

@RestController
@RequestMapping(value = "/distritos", produces = "application/json")
@CrossOrigin(origins = "*")
public class DistritoController {

	@Autowired
	private DistritoRepository executeRepository;
	@Autowired
	private DistritoService service;

	@GetMapping
	public List<Distrito> listar() {
		return executeRepository.findAll();
	}
	@GetMapping("/ativos")
	public List<Distrito> listarAtivos() {
		return executeRepository.findAllByAtivoIsTrue();
	}
	@GetMapping("/inativos")
	public List<Distrito> listarInativos() {
		return executeRepository.findAllByAtivoIsFalse();
	}
	
	@GetMapping("/{executeId}")
	public ResponseEntity<Distrito> buscar(@PathVariable Long executeId) {
		Optional<Distrito> distritoDoBanco = executeRepository.findById(executeId);
		if (distritoDoBanco.isPresent()) {
			return ResponseEntity.ok(distritoDoBanco.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/buscarcodigo/{codigoDistrito}")
	public ResponseEntity<Distrito> buscarPorCodigoDistrito(@PathVariable String codigoDistrito) {
		Optional<Distrito> distritoDoBanco = executeRepository.findByCodigo(codigoDistrito);
		if (distritoDoBanco.isPresent()) {
			return ResponseEntity.ok(distritoDoBanco.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
	public ResponseEntity<?> criar(@RequestBody Distrito distrito) {
		return service.salvar(distrito);
	}

	@PutMapping("/{executeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long executeId, @RequestBody Distrito distrito) {
		return service.atualizar(distrito, executeId);
	}
	
	@PatchMapping("/{executeId}")
	public ResponseEntity<Distrito> atualizarParcial(@PathVariable Long executeId, @RequestBody DistritoRecordDTO distrito) {
		Optional<Distrito> distritoDoBanco = executeRepository.findById(executeId);
		
		if (distritoDoBanco.isPresent()) {
			distritoDoBanco.get().setId(executeId);
			return ResponseEntity.ok(executeRepository.save(distritoDoBanco.get()));
		}
		return ResponseEntity.notFound().build(); // build ao fim para construir o response entity do tipo informado na											// assinatura.
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
