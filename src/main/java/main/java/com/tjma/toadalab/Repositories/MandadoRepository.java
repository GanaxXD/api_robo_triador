package main.java.com.tjma.toadalab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.tjma.toadalab.Models.Mandado;

@Repository
public interface MandadoRepository extends JpaRepository<Mandado, Long> {

}
