package main.java.com.tjma.toadalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.tjma.toadalab.models.ProcessosRemetidosAoSegundoGrau;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessosRemetidosRepository extends JpaRepository<ProcessosRemetidosAoSegundoGrau, Long>{
}
