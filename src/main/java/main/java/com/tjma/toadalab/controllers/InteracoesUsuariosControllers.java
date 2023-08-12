package main.java.com.tjma.toadalab.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import main.java.com.tjma.toadalab.models.InteracoesUsuario;
import main.java.com.tjma.toadalab.repositories.InteracoesUsuariosRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/interacoes", produces = "application/json")
public class InteracoesUsuariosControllers {
	@Autowired
	private InteracoesUsuariosRepository repository;
	
	@GetMapping
	public List<InteracoesUsuario> listar(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InteracoesUsuario> buscar(@PathVariable Long id){
		Optional<InteracoesUsuario> interacaoBanco = repository.findById(id);
		if(interacaoBanco.isPresent()) {
			return ResponseEntity.ok(interacaoBanco.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
	public ResponseEntity<String> criar(@Valid @RequestBody InteracoesUsuario interacoes){
		if(interacoes.equals(null)) {
			return ResponseEntity.badRequest().body("Interacao com dados inválidos: "+interacoes.toString());
		}
		repository.save(interacoes);
		return ResponseEntity.ok(interacoes.toString());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody InteracoesUsuario novaInteracao){
		Optional<InteracoesUsuario> interacaoBanco = repository.findById(id);
		if(interacaoBanco.isEmpty()) {
			return ResponseEntity.badRequest().body("Interacao com id não cadastrada no banco. Id passado: "+id);
		}
		novaInteracao.setId(id);
		return ResponseEntity.ok(repository.save(novaInteracao).toString());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		Optional<InteracoesUsuario> interacaoBanco = repository.findById(id);
		if(interacaoBanco.isPresent()) {
			repository.delete(interacaoBanco.get());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Interação excluída com sucesso!");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interacao não encontrada na base de dados: Id "+id);
	}
}
