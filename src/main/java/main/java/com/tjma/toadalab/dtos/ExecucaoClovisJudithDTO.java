package main.java.com.tjma.toadalab.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import main.java.com.tjma.toadalab.models.Robo;

public record ExecucaoClovisJudithDTO(LocalTime tempoEtiquetandoProcessos, int quantidadeProcessosEtiquetados,int quantidadeEtiquetasInseridas,  LocalDate rodouEm, int qtdProcessosLidos, boolean houveErro, String horaInicialExecucaoRobo, int minutasInseridas, Robo robo_id) {

}
