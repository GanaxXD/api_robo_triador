package main.java.com.tjma.toadalab.dtos;

import java.time.LocalDateTime;

import main.java.com.tjma.toadalab.models.Robo;

public record ProcessosRemetidos(int quantidadeProcessosRemetidos, LocalDateTime dataExecucao, Robo robo_id) {

}
