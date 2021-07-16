package br.com.alura.escolalura.dominio.tratamentoexception.curso.controller;

import br.com.alura.escolalura.dominio.tratamentoexception.ErroApiForm;
import br.com.alura.escolalura.dominio.tratamentoexception.curso.exception.CamposObrigatoriosCursoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CursoControllerExceptionHandler {
    private ResponseEntity<Object> buildResponseEntity(ErroApiForm erroApi) {
        return new ResponseEntity<>(erroApi, erroApi.getStatus());
    }

    @ExceptionHandler(CamposObrigatoriosCursoException.class)
    protected ResponseEntity<Object> handlenCamposObrigatoriosCursoException(CamposObrigatoriosCursoException ex) {
        ErroApiForm form = new ErroApiForm(HttpStatus.BAD_REQUEST, ex);
        return buildResponseEntity(form);
    }
}
