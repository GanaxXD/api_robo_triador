package main.java.com.tjma.toadalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.tjma.toadalab.models.ExecucaoClovisJudith;

//Repositório de Execução
@Repository
public interface ExecucaoClovisJudithRepository extends JpaRepository<ExecucaoClovisJudith, Long> {
}
