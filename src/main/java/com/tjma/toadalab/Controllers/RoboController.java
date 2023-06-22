package com.tjma.toadalab.Controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

import com.tjma.toadalab.Models.Robo;
import com.tjma.toadalab.Repositories.RobosRepository;
import com.tjma.toadalab.Services.Validador;

@RestController
@RequestMapping(value="/robos", produces = "application/json")
@CrossOrigin(origins="*")
public class RoboController {

	@Autowired
	private RobosRepository roboRepository;

	@Autowired
	private CacheManager cacheManager;

	private Validador validador = new Validador();

	@GetMapping()
	@Cacheable(value="lista_robos")//dando um apelido para esse cache
	public List<Robo> listar(){
		return roboRepository.findAll();
	}

	@GetMapping("/{roboId}")
	@Cacheable(value="robo_unico_pelo_id")
	public ResponseEntity<Robo> buscarpeloId(@PathVariable Long roboId) {
		Optional<Robo> robo = roboRepository.findById(roboId);

		//O código de resposta da requisão não pode ser 200 caso seja nulo o cliente, logo...
		if(robo.isPresent()) {
			//retorna o código 200 pra requisição
			return ResponseEntity.ok(robo.get());
		}

		return ResponseEntity.notFound().build(); //build ao fim para construir o response entity do tipo informado na assinatura.
	}

	@GetMapping("/buscar/{numeroRobo}")
	@Cacheable(value="robo_unico_pelo_nome")
	public ResponseEntity<Robo> buscarpeloNome(@PathVariable String numeroRobo) {

		//Passando acentos pela URL, o decodificador está encontrando erros na conversão (RFC 7230 e RFC 3986)
		String roboName = "ToadaRobô"+numeroRobo;

		List<Robo> robo = roboRepository.findByNomeRoboContains(roboName);

		if(!robo.isEmpty()) {
			return ResponseEntity.ok(robo.get(0));
		}

		return ResponseEntity.notFound().build(); //build ao fim para construir o response entity do tipo informado na assinatura.
	}

	@GetMapping("/buscar/processosparados/{numeroRobo}")
	@Cacheable(value="robo_processos_parados")
	public ResponseEntity<Robo> buscarProcessosParadosNome(@PathVariable String numeroRobo) {

		//Passando acentos pela URL, o decodificador está encontrando erros na conversão (RFC 7230 e RFC 3986)
		String roboName = "ProcessosParados"+numeroRobo;

		List<Robo> robo = roboRepository.findByNomeRoboContains(roboName);

		//O código de resposta da requisão não pode ser 200 caso seja nulo o cliente, logo...
		if(!robo.isEmpty()) {
			//retorna o código 200 pra requisição
			return ResponseEntity.ok(robo.get(0));
		}

		return ResponseEntity.notFound().build(); //build ao fim para construir o response entity do tipo informado na assinatura.
	}


	@PostMapping(consumes = {"application/json", "application/text"})
	@CacheEvict(value="lista_robos", allEntries = true)
	public ResponseEntity<Robo> criar(@RequestBody Robo robo) {
		if(robo==null || roboRepository.findByNomeRobo(robo.getNomeRobo()).isPresent() == true) {
			return ResponseEntity.badRequest().build();
		}
		robo.setInstaladoEm(LocalDate.now());
		Robo r = roboRepository.save(robo);
		cacheManager.getCache("robo_processos_parados").clear();
		return ResponseEntity.ok( r );
	}

	@PutMapping("/{roboId}")
	@CacheEvict(value= "robo_unico_pelo_id", allEntries = true)
	public ResponseEntity<Robo> atualizar (@Validated @RequestBody Robo robo, @PathVariable Long roboId) {

		if(!roboRepository.existsById(roboId)) {
			return ResponseEntity.notFound().build();
		}
		if(robo.getInstaladoEm() == null || robo.getInstaladoEm().equals("")) {
			Robo r = roboRepository.findById(roboId).get();
			robo.setInstaladoEm(r.getInstaladoEm());
		}
		robo.setId(roboId);
		roboRepository.save(robo);
		cacheManager.getCache("lista_robos").clear();
		cacheManager.getCache("robo_processos_parados").clear();
		return ResponseEntity.ok(robo);
	}

	@DeleteMapping("/{roboId}")
	@CacheEvict(value="lista_robos", allEntries = true)
	public ResponseEntity<Void> deletar (@PathVariable Long roboId){
		if(!roboRepository.existsById(roboId)) {
			return ResponseEntity.notFound().build();
		}
		//clientInterface.deletar(clientInterface.findById(clientId).get());
		roboRepository.delete(roboRepository.findById(roboId).get());
		cacheManager.getCache("robo_processos_parados").clear();
		return ResponseEntity.noContent().build();
	}
}
