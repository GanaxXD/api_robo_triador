package com.tjma.toadalab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjma.toadalab.Models.Mandado;

@Repository
public interface MandadoRepository extends JpaRepository<Mandado, Long>{

}
