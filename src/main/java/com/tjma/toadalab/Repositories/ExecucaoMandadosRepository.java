package com.tjma.toadalab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjma.toadalab.Models.ExecucaoMandados;
//Repositório de Execução
@Repository
public interface ExecucaoMandadosRepository extends JpaRepository<ExecucaoMandados, Long>{

}
