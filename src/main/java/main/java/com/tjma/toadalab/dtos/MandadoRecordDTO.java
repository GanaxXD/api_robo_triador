package main.java.com.tjma.toadalab.dtos;


import java.util.Date;

import main.java.com.tjma.toadalab.models.Distrito;

public record MandadoRecordDTO(String numeroProcesso, String codigoMandado, String idDocumento, Distrito distrito, Date dataDistribuicao) {

}
