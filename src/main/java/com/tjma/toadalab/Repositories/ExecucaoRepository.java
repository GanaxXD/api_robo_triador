package com.tjma.toadalab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjma.toadalab.Models.Execucao;
//Repositório de Execução
@Repository
public interface ExecucaoRepository extends JpaRepository<Execucao, Long>{

}
