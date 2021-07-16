package br.com.alura.escolalura.dominio.tratamentoexception.aluno.exception;

public class ListaAlunoException extends RuntimeException {
    public ListaAlunoException() {
        super("Erro ao listar alunos");
    }
}
