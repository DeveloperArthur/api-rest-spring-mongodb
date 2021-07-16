package br.com.alura.escolalura.dominio.tratamentoexception.habilidade.exception;

public class CamposObrigatoriosHabilidadeException extends RuntimeException {
    public CamposObrigatoriosHabilidadeException() {
        super("Nome e Nivel sao obrigatorios para criar uma habilidade");
    }
}
