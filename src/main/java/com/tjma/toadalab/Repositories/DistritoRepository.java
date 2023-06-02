package main.java.com.tjma.toadalab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.tjma.toadalab.Models.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Long>{

}
