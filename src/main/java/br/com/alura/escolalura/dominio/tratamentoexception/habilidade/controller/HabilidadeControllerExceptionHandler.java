package br.com.alura.escolalura.dominio.tratamentoexception.habilidade.controller;

import br.com.alura.escolalura.dominio.tratamentoexception.ErroApiForm;
import br.com.alura.escolalura.dominio.tratamentoexception.habilidade.exception.CamposObrigatoriosHabilidadeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HabilidadeControllerExceptionHandler {
    private ResponseEntity<Object> buildResponseEntity(ErroApiForm erroApi) {
        return new ResponseEntity<>(erroApi, erroApi.getStatus());
    }

    @ExceptionHandler(CamposObrigatoriosHabilidadeException.class)
    protected ResponseEntity<Object> handleCamposObrigatoriosHabilidadeException(CamposObrigatoriosHabilidadeException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_REQUEST, ex);
        return buildResponseEntity(form);
    }
}
