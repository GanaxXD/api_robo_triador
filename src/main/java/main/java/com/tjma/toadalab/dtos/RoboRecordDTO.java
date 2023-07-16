package main.java.com.tjma.toadalab.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;



/*
 * Para facilitar a criação dos DTOs (Data Transfer Object, 
 * que serão responsáveis por transformar os objetos do banco 
 * em objetos java e vice-versa, usaremos uma API do JAva 16,
 * O Java Records. Ele facilita a tranformação desses dados 
 * do banco em objetos java.
 * 
 * Records são imutáveis, logo, uma vez criados, não podem ser alterados.
 * Records só possuem métodos geters
 * Records só precisam dos parâmetros que serão enviados ao banco.
 */
public record RoboRecordDTO(@NotNull String tipo, @NotNull String localImplantado, LocalDate instaladoEm, @UniqueElements String nomeRobo, String grau) {}
