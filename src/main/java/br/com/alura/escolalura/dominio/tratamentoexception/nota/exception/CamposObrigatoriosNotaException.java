package br.com.alura.escolalura.dominio.tratamentoexception.nota.exception;

public class CamposObrigatoriosNotaException extends RuntimeException {
    public CamposObrigatoriosNotaException() {
        super("Valor eh obrigatorio para criar uma Nota");
    }
}
