package main.java.com.tjma.toadalab.dtos;

import javax.validation.constraints.NotNull;

import main.java.com.tjma.toadalab.models.Robo;

public record InteracoesUsuariosRecordDTO(@NotNull int quantidadeClick, @NotNull Robo ribiId) {

}
