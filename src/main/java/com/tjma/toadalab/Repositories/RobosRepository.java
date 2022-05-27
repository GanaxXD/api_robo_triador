package main.java.com.tjma.toadalab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import main.java.com.tjma.toadalab.Models.Robo;

@Repository
public interface RobosRepository extends JpaRepository<Robo, Long>{

}
