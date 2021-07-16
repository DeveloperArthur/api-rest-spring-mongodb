package br.com.alura.escolalura.dominio.tratamentoexception.nota.controller;

import br.com.alura.escolalura.dominio.tratamentoexception.ErroApiForm;
import br.com.alura.escolalura.dominio.tratamentoexception.nota.exception.CamposObrigatoriosNotaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotaControllerExceptionHandler {
    private ResponseEntity<Object> buildResponseEntity(ErroApiForm erroApi) {
        return new ResponseEntity<>(erroApi, erroApi.getStatus());
    }

    @ExceptionHandler(CamposObrigatoriosNotaException.class)
    protected ResponseEntity<Object> handleCamposObrigatoriosNotaException(CamposObrigatoriosNotaException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_REQUEST, ex);
        return buildResponseEntity(form);
    }
}
