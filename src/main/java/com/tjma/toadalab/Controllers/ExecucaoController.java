package com.tjma.toadalab.Controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

import com.tjma.toadalab.Models.Execucao;
import com.tjma.toadalab.Models.ExecucaoMandados;
import com.tjma.toadalab.Models.Robo;
import com.tjma.toadalab.Repositories.ExecucaoMandadosRepository;
import com.tjma.toadalab.Repositories.ExecucaoRepository;
import com.tjma.toadalab.Repositories.RobosRepository;

@RestController
@RequestMapping(value="/execucoes", produces = "application/json")
@CrossOrigin(origins = "*")
public class ExecucaoController { 

	@Autowired
	private ExecucaoRepository executeRepository;

	@Autowired
	private ExecucaoMandadosRepository executeMandRepository;

	@Autowired
	private RobosRepository robosRepository;

	@GetMapping
	@Cacheable(value="lista_execucoes")//dando um apelido para esse cache
	public List<Execucao> listar(){
		return executeRepository.findAll();
	}

	@GetMapping("/mandados")
	@Cacheable(value="lista_mandados")//dando um apelido para esse cache
	public List<ExecucaoMandados> listarMandados(){
		return executeMandRepository.findAll();
	}

	@GetMapping("/{executeId}")
	@Cacheable(value="execucao_unica")//dando um apelido para esse cache
	public ResponseEntity<Execucao> buscar(@PathVariable Long executeId) {
		Optional<Execucao> execucao = executeRepository.findById(executeId);

		//O código de resposta da requisão não pode ser 200 caso seja nulo o cliente, logo...
		if(execucao.isPresent()) {
			//retorna o código 200 pra requisição
			return ResponseEntity.ok(execucao.get());
		}

		return ResponseEntity.notFound().build(); //build ao fim para construir o response entity do tipo informado na assinatura.
	}

	@GetMapping("/mandados/{executeId}")
	@Cacheable(value="mandado_unico")//dando um apelido para esse cache
	public ResponseEntity<ExecucaoMandados> buscarMandado(@PathVariable Long executeId) {
		Optional<ExecucaoMandados> execucao = executeMandRepository.findById(executeId);

		//O código de resposta da requisão não pode ser 200 caso seja nulo o cliente, logo...
		if(execucao.isPresent()) {
			//retorna o código 200 pra requisição
			return ResponseEntity.ok(execucao.get());
		}

		return ResponseEntity.notFound().build(); //build ao fim para construir o response entity do tipo informado na assinatura.
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
	@CacheEvict(value="[lista_execucoes, execucao_unica]", allEntries = true)
	public ResponseEntity<Execucao> criar(@RequestBody Execucao execucao) {
		Robo robo = robosRepository.findById(execucao.getRobo_id().getId()).orElse(null);
		if(robo==null) {
			System.out.println("O robô de código "+execucao.getRobo_id().getId()+" não foi encontrado no banco de dados.");
			return ResponseEntity.notFound().build();
		}
		execucao.setRobo_id(robo);
		execucao.setRodouEm(LocalDate.now());
		Execucao ex = executeRepository.save(execucao);
		return  ex==null ?  ResponseEntity.badRequest().build() :  ResponseEntity.ok().build();
	}

	@PostMapping("/mandados")
	@ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
	@CacheEvict(value="[lista_mandados, mandado_unico]", allEntries = true)
	public ResponseEntity<ExecucaoMandados> criarMandado(@RequestBody ExecucaoMandados execucao) {
		System.out.println(execucao);
		Robo robo = robosRepository.findById(execucao.getRobo().getId()).get();
		if(robo==null) {
			System.out.println("O robô de código "+execucao.getRobo().getId()+" não foi encontrado no banco de dados.");
			return ResponseEntity.notFound().build();
		}
		execucao.setRobo(robo);
		execucao.setRodouEm(LocalDate.now());
		ExecucaoMandados ex = executeMandRepository.save(execucao);
		return ex == null ? ResponseEntity.badRequest().build() :ResponseEntity.ok().build();
	}

	@PutMapping("/{executeId}")
	@CacheEvict(value="[lista_execucoes, execucao_unica]", allEntries = true)
	public ResponseEntity<Execucao> atualizar(@RequestBody Execucao execucao, @PathVariable Long executeId) {
		if(!executeRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}

		execucao.setId(executeId);
		return ResponseEntity.ok(executeRepository.save(execucao));
	}

	@PutMapping("/mandados/{executeId}")
	@CacheEvict(value="[lista_mandados, mandado_unico]", allEntries = true)
	public ResponseEntity<ExecucaoMandados> atualizarMandado(@RequestBody ExecucaoMandados execucao, @PathVariable Long executeId) {
		if(!executeMandRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}

		execucao.setId(executeId);
		return ResponseEntity.ok(executeMandRepository.save(execucao));
	}

	@DeleteMapping("/{executeId}")
	@CacheEvict(value="[lista_execucoes, execucao_unica]", allEntries = true)
	public ResponseEntity<Void> deletar (@PathVariable Long executeId){
		if(!executeRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}
		//clientInterface.deletar(clientInterface.findById(clientId).get());
		executeRepository.delete(executeRepository.findById(executeId).get());
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/mandados/{executeId}")
	@CacheEvict(value="[lista_mandados, mandado_unico]", allEntries = true)
	public ResponseEntity<Void> deletarMandado (@PathVariable Long executeId){
		if(!executeMandRepository.existsById(executeId)) {
			return ResponseEntity.notFound().build();
		}
		//clientInterface.deletar(clientInterface.findById(clientId).get());
		executeMandRepository.delete(executeMandRepository.findById(executeId).get());
		return ResponseEntity.noContent().build();
	}


	@Override
	public String toString() {
		return "ExecucaoController [executeRepository=" + executeRepository + ", executeMandRepository="
				+ executeMandRepository + ", robosRepository=" + robosRepository + "]";
	}
}
