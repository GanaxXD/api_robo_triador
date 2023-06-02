package main.java.com.tjma.toadalab.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.tjma.toadalab.Models.Distrito;
import main.java.com.tjma.toadalab.Repositories.DistritoRepository;
@RestController
@RequestMapping(value="/distritos", produces = "application/json")
@CrossOrigin(origins = "*")
public class DistritoController {

	@Autowired
	private DistritoRepository executeRepository;

	@GetMapping
	public List<Distrito> listar(){
		return executeRepository.findAll();
	}
	
	@GetMapping("/{executeId}")
	public ResponseEntity<Distrito> buscar(@PathVariable Long executeId) {
		Optional<Distrito> execucao = executeRepository.findById(executeId);
		
		//O código de resposta da requisão não pode ser 200 caso seja nulo o cliente, logo...
		if(execucao.isPresent()) {
			//retorna o código 200 pra requisição
			return ResponseEntity.ok(execucao.get());
		}
		
		return ResponseEntity.notFound().build(); //build ao fim para construir o response entity do tipo informado na assinatura.
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
	public ResponseEntity<Distrito> criar(@RequestBody Distrito distrito) {
		if(distrito==null) {
			System.out.println("O distrito não é válido!");
			return ResponseEntity.badRequest().build();
		} 
		if(executeRepository.findByCodNormal(distrito.getCodNormal()) != null
				||executeRepository.findByCodUrgente(distrito.getCodUrgente()) != null 
				||executeRepository.findByNomeDistrito(distrito.getNomeDistrito())!= null ) {
			System.out.println("Distrito com código normal, urgente ou nome já existente no banco.");
			return ResponseEntity.badRequest().build();
		}
		executeRepository.save(distrito);
		return  ResponseEntity.ok(distrito);
	}
	
}
