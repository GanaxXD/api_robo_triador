package main.java.com.tjma.toadalab.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class APIHandlerException extends ResponseEntityExceptionHandler {
    @Autowired
    public MessageSource messageSource;

    @ExceptionHandler(TriadorException.class)
    public ResponseEntity<Object> handlerNegocio(TriadorException ex, WebRequest web){
        var status = HttpStatus.BAD_REQUEST;
        Problema problema = new Problema();

        problema.setStatusDaRequisicao(status.value());
        problema.setDataDoErro(OffsetDateTime.now());
        problema.setTituloDoErro(ex.getMessage());

        return super.handleExceptionInternal(ex, problema, new HttpHeaders(), status, web);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {

        ArrayList<Campos> campos = new ArrayList<Campos>();

        //Iterando pelos erros existentes no MethodArgumentNotValidException
        for(ObjectError erro : ex.getBindingResult().getAllErrors()) {
            String nome=((FieldError) erro).getField();
            String mensagem = erro.getDefaultMessage();//erro.messageSource.getMessage(erro, LocaleContextHolder.getLocale()); //ou é error ou erro
            campos.add(new Campos(nome, mensagem));
        }

        var problema = new Problema();
        problema.setStatusDaRequisicao(status.value());
        problema.setDataDoErro(OffsetDateTime.now());
        problema.setAtributosCausadoresErro(campos);
        problema.setTituloDoErro("Dados incorretos ou não preenchidos. Preencha todos os dados e tente novamente.");
        return super.handleExceptionInternal(ex, problema, headers, status, request);
    }
}
