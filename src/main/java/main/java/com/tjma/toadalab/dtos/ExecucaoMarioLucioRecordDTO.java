package main.java.com.tjma.toadalab.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import main.java.com.tjma.toadalab.models.Robo;

public record ExecucaoMarioLucioRecordDTO(LocalTime tempoDistribuindoMandados, int quantidadeMandadosEnviados, int quantidadeMandadosEnviadosParaAnalise, LocalDate rodouEm, boolean houveErro, String horaInicialExecucaoRobo, Robo robo) {

}
