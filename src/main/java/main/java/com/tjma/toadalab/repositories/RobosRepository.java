package main.java.com.tjma.toadalab.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.tjma.toadalab.models.Robo;

@Repository
public interface RobosRepository extends JpaRepository<Robo, Long> {
	List<Robo> findByNomeRoboContains(String nome);
	Optional<Robo> findByNomeRobo(String nomeRobo);
	Optional<Robo> findByTipo(String tipo);
}
