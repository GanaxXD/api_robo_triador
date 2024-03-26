package main.java.com.tjma.toadalab.repositories;

import main.java.com.tjma.toadalab.models.Processos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessosRepository extends JpaRepository<Processos, Long> {
}
