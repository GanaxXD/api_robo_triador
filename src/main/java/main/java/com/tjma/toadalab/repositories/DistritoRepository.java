package main.java.com.tjma.toadalab.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.tjma.toadalab.models.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Long> {

	Optional<Distrito> findByCodigo(String codigo);

	Optional<Distrito> findByNomeDistrito(String nomeDistrito);
	
	List<Distrito> findAllByAtivoIsTrue();
	
	List<Distrito> findAllByAtivoIsFalse();
}
