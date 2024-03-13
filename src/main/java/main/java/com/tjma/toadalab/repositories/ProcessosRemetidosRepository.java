package main.java.com.tjma.toadalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.tjma.toadalab.models.ProcessosRemetidos;

@Repository
public interface ProcessosRemetidosRepository extends JpaRepository<ProcessosRemetidos, Long>{

}
