package main.java.com.tjma.toadalab.Controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.tjma.toadalab.Models.Robo;
import main.java.com.tjma.toadalab.Repositories.RobosRepository;

@RestController
@RequestMapping(value="/robos", produces = "application/vnd.baeldung.api.v1+json")
@CrossOrigin(origins="*")
public class RoboController {

	@Autowired
	private RobosRepository roboRepository;
	
	@GetMapping()
	public List<Robo> listar(){
		return roboRepository.findAll();
	}
	
	@GetMapping("/{roboId}")
	public ResponseEntity<Robo> buscarpeloId(@PathVariable Long roboId) {
		Optional<Robo> robo = roboRepository.findById(roboId);
		
		//O código de resposta da requisão não pode ser 200 caso seja nulo o cliente, logo...
		if(robo.isPresent()) {
			//retorna o código 200 pra requisição
			return ResponseEntity.ok(robo.get());
		}
		
		return ResponseEntity.notFound().build(); //build ao fim para construir o response entity do tipo informado na assinatura.
	}
	
	@GetMapping("/{roboName}")
	public ResponseEntity<Robo> buscarpeloNome(@PathVariable String roboName) {
		List<Robo> robo = roboRepository.findByNomeRoboContains(roboName);
		
		//O código de resposta da requisão não pode ser 200 caso seja nulo o cliente, logo...
		if(!robo.isEmpty()) {
			//retorna o código 200 pra requisição
			return ResponseEntity.ok(robo.get(0));
		}
		
		return ResponseEntity.notFound().build(); //build ao fim para construir o response entity do tipo informado na assinatura.
	}
	
	
	@PostMapping(consumes = {"application/json", "application/text"})
	@ResponseStatus(value = HttpStatus.CREATED)
	public Robo criar(@RequestBody Robo robo) {
		if(robo.equals(null)) {
			ResponseEntity.badRequest().build();
			return null;
		}
		robo.setInstaladoEm(LocalDate.now());
		return roboRepository.save(robo);
	}
	
	@PutMapping(name = "/{roboId}", consumes = {"application/json", "application/text"})
	public ResponseEntity<Robo> atualizar (@Validated @RequestBody Robo robo, @PathVariable(value = "roboId") Long roboId) {

		if(!roboRepository.existsById(roboId)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(roboRepository.save(robo));
	}
	
	@DeleteMapping("/{roboId}")
	public ResponseEntity<Void> deletar (@PathVariable Long roboId){
		if(!roboRepository.existsById(roboId)) {
			return ResponseEntity.notFound().build();
		}
		//clientInterface.deletar(clientInterface.findById(clientId).get());
		roboRepository.delete(roboRepository.findById(roboId).get());
		return ResponseEntity.noContent().build();
	}
}
