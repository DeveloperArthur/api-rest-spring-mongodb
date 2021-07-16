package br.com.alura.escolalura.dominio.tratamentoexception.aluno.exception;

public class CamposObrigatoriosAlunoException extends RuntimeException {
    public CamposObrigatoriosAlunoException() {
        super("Nome e Data de Nascimento sao obrigatorios para criar um aluno");
    }
}
