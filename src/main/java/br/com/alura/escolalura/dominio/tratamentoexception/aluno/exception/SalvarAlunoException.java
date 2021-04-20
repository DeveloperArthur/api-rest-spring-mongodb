package br.com.alura.escolalura.dominio.tratamentoexception.aluno.exception;

public class SalvarAlunoException extends RuntimeException {
    public SalvarAlunoException() {
        super("Erro ao salvar aluno");
    }
}
