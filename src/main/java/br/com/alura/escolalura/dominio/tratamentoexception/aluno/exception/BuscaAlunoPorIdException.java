package br.com.alura.escolalura.dominio.tratamentoexception.aluno.exception;

public class BuscaAlunoPorIdException extends RuntimeException {
    public BuscaAlunoPorIdException() {
        super("Erro ao buscar aluno por id");
    }
}
