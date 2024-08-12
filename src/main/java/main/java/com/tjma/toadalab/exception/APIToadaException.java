package main.java.com.tjma.toadalab.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class APIToadaException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String mensagem;

    public APIToadaException (String mensagem){
        this.mensagem = mensagem;
    }
}
