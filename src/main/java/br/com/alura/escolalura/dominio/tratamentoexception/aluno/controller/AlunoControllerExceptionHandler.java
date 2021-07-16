package br.com.alura.escolalura.dominio.tratamentoexception.aluno.controller;

import br.com.alura.escolalura.dominio.tratamentoexception.ErroApiForm;
import br.com.alura.escolalura.dominio.tratamentoexception.aluno.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AlunoControllerExceptionHandler {
    private ResponseEntity<Object> buildResponseEntity(ErroApiForm erroApi) {
        return new ResponseEntity<>(erroApi, erroApi.getStatus());
    }

    @ExceptionHandler(CamposObrigatoriosAlunoException.class)
    protected ResponseEntity<Object> handleCamposObrigatoriosAlunoException(CamposObrigatoriosAlunoException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_REQUEST, ex);
        return buildResponseEntity(form);
    }

    @ExceptionHandler(SalvarAlunoException.class)
    protected ResponseEntity<Object> handleSalvarAlunoException(SalvarAlunoException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_GATEWAY, ex);
        return buildResponseEntity(form);
    }

    @ExceptionHandler(ListaAlunoException.class)
    protected ResponseEntity<Object> handleListaAlunoException(ListaAlunoException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_GATEWAY, ex);
        return buildResponseEntity(form);
    }

    @ExceptionHandler(BuscaAlunoPorIdException.class)
    protected ResponseEntity<Object> handleBuscaAlunoPorIdException(BuscaAlunoPorIdException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_GATEWAY, ex);
        return buildResponseEntity(form);
    }

    @ExceptionHandler(BuscaAlunoPorNomeException.class)
    protected ResponseEntity<Object> handleBuscaAlunoPorNomeException(BuscaAlunoPorNomeException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_GATEWAY, ex);
        return buildResponseEntity(form);
    }

    @ExceptionHandler(BuscaAlunoPorClassificacaoENotaException.class)
    protected ResponseEntity<Object> handleBuscaAlunoPorClassificacaoENotaException(BuscaAlunoPorClassificacaoENotaException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_GATEWAY, ex);
        return buildResponseEntity(form);
    }
}
