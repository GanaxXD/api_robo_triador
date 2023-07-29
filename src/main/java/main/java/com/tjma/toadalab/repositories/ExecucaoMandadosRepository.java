package main.java.com.tjma.toadalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.tjma.toadalab.models.ExecucaoMarioLucio;

//Repositório de Execução
@Repository
public interface ExecucaoMandadosRepository extends JpaRepository<ExecucaoMarioLucio, Long> {

}
