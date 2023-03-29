package main.java.com.tjma.toadalab.Controllers;

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

import main.java.com.tjma.toadalab.Models.DadosEnvioMandados;
import main.java.com.tjma.toadalab.Repositories.DadosEnvioMandadosRepository;

@RestController
@RequestMapping(value="/dadosmandados", produces="application/json")
@CrossOrigin(origins = "*")
public class ExecucaoDadosMandadosController {

	@Autowired
	private DadosEnvioMandadosRepository repositorio;
	
	String mensagem = "Não foi passado na requisição o id do objeto que se deseja excluir ou atualizar.";
	
	@GetMapping()
	public List<DadosEnvioMandados> listar(){
		return repositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosEnvioMandados> buscar(@PathVariable Long id){
		Optional<DadosEnvioMandados> dados = repositorio.findById(id);
		
		if(dados.isEmpty()) {
			System.out.println("Não achei nenhum dado com o id informado!");
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(dados.get());
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<DadosEnvioMandados> criar(@RequestBody @Validated DadosEnvioMandados dados){
		DadosEnvioMandados d = repositorio.save(dados);
		return d.equals(null) ? ResponseEntity.badRequest().build() : ResponseEntity.ok(dados);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public ResponseEntity<DadosEnvioMandados> atualizar(@RequestBody DadosEnvioMandados dados, @PathVariable Long id){
		if(!repositorio.existsById(id)) {
			System.out.println("Dados de Execução do Robô de Mandados não encontrado no banco de dados para o id passado.");
			return ResponseEntity.notFound().build();
		}
		dados.setId(id);
		return ResponseEntity.ok(repositorio.save(dados));
	}
	
	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> atualizar(){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		if(repositorio.existsById(id)) {
			repositorio.delete(repositorio.findById(id).get());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/")
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> deletar(){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
	}
}
