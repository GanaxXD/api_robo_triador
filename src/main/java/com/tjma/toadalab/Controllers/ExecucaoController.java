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

import main.java.com.tjma.toadalab.Models.Execucao;
import main.java.com.tjma.toadalab.Repositories.ExecucaoRepository;

@RestController
@RequestMapping(value="/execucoes", produces = "application/vnd.baeldung.api.v1+json")
@CrossOrigin(origins = "*")
public class ExecucaoController {
	
	@Autowired
	private ExecucaoRepository executeRepository;
	
	@GetMapping()
	public List<Execucao> listar(){
		return executeRepository.findAll();
	}
	
	@GetMapping("/{executeId}")
	public ResponseEntity<Execucao> buscar(@PathVariable Long executeId) {
		Optional<Execucao> execucao = executeRepository.findById(executeId);
		
		//O código de resposta da requisão não pode ser 200 caso seja nulo o cliente, logo...
		if(execucao.isPresent()) {
			//retorna o código 200 pra requisição
			return ResponseEntity.ok(execucao.get());
		}
		
		return ResponseEntity.notFound().build(); //build ao fim para construir o response entity do tipo informado na assinatura.
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Execucao criar(@RequestBody Execucao execucao) {
		return executeRepository.save(execucao);
	}
	
	@PutMapping("/{executeId}")
	public ResponseEntity<Execucao> atualizar(@RequestBody Execucao execucao, @PathVariable Long executeId) {

		if(!executeRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}
				
		execucao.setId(executeId);
		return ResponseEntity.ok(executeRepository.save(execucao));
	}
	
	@DeleteMapping("/{executeId}")
	public ResponseEntity<Void> deletar (@PathVariable Long executeId){
		if(!executeRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}
		//clientInterface.deletar(clientInterface.findById(clientId).get());
		executeRepository.delete(executeRepository.findById(executeId).get());
		return ResponseEntity.noContent().build();
	}
}
