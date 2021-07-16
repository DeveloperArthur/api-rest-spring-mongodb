package br.com.alura.escolalura.dominio.tratamentoexception.aluno.exception;

public class BuscaAlunoPorNomeException extends RuntimeException {
    public BuscaAlunoPorNomeException() {
        super("Erro ao buscar aluno por nome");
    }
}
