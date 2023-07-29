package main.java.com.tjma.toadalab.dtos;

import java.util.List;

import main.java.com.tjma.toadalab.models.Mandado;

public record DistritoRecordDTO(String nomeDistrito, String codNormal, String codUrgente, List<Mandado> mandados) {

}
