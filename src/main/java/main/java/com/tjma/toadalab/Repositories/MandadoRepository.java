package main.java.com.tjma.toadalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.tjma.toadalab.models.Mandado;

@Repository
public interface MandadoRepository extends JpaRepository<Mandado, Long> {

}
