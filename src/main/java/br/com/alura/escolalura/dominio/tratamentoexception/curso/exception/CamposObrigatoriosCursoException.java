package br.com.alura.escolalura.dominio.tratamentoexception.curso.exception;

public class CamposObrigatoriosCursoException extends RuntimeException {
    public CamposObrigatoriosCursoException() {
        super("Nome eh obrigatorio para criar curso");
    }
}
