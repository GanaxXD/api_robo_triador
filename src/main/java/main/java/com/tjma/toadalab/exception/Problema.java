package main.java.com.tjma.toadalab.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problema {
    private Integer statusDaRequisicao;
    private String tituloDoErro;
    private OffsetDateTime dataDoErro;
    private List<Campos> atributosCausadoresErro;
}
