package main.java.com.tjma.toadalab.services;

import main.java.com.tjma.toadalab.dtos.DistritoRecordDTO;
import main.java.com.tjma.toadalab.exception.APIToadaException;
import main.java.com.tjma.toadalab.models.Distrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import main.java.com.tjma.toadalab.repositories.DistritoRepository;

import java.util.Optional;

@Service
public class DistritoService {

	@Autowired
	private DistritoRepository distritoRepository;

	public ResponseEntity<?> salvar(Distrito distrito){
		Distrito distritoDoBanco = distritoRepository.findByCodigo(distrito.getCodigo()).orElse(null);
		if (distritoDoBanco != null) {
			System.err.println("O distrito não é válido!");
			throw new APIToadaException("Há um Distrito Ativo com código já cadastrado no banco: " + distritoDoBanco.toString());
		}
		if(this.validarDistrito(distrito)) {
			Distrito dist = distritoRepository.save(distrito);
			DistritoRecordDTO distritoResposta = new DistritoRecordDTO(dist.getNomeDistrito(), dist.getCodigo(), dist.getBairro(), true);
			return ResponseEntity.ok().body("Cadastro realizado:"+distritoResposta);
		}else {
			return ResponseEntity.badRequest().body("O distrito cadastrado não é válido: Nome do Distrito ou Código do Distrito já cadastrado no sistema.");
		}
	}

	public ResponseEntity<?> atualizar(Distrito distrito, Long id){
		Optional<Distrito> distritoDoBanco = distritoRepository.findById(id);
		if (distritoDoBanco.isPresent()) {
			distrito.setId(id);
			return validarDistrito(distrito) ? ResponseEntity.ok(distritoRepository.save(distrito)) : ResponseEntity.badRequest().body("Nome ou código do distrito está com valor nulo.");
		}
		return ResponseEntity.notFound().build();
	}

	public boolean validarDistrito(Distrito dados) {
		boolean codigoValido = false;
		boolean nomeValido = false;
		if(dados.getCodigo() != null && !dados.getCodigo().trim().equals("")) {
			codigoValido = true;
		}
		if(dados.getNomeDistrito() != null && !dados.getNomeDistrito().trim().equals("")) {
			nomeValido = true;
		}
		if(codigoValido && nomeValido) return true;
		return false;
	}
}
