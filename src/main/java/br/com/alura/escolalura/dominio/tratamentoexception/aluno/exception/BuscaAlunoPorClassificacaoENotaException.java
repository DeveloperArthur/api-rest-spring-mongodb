package br.com.alura.escolalura.dominio.tratamentoexception.aluno.exception;

public class BuscaAlunoPorClassificacaoENotaException extends RuntimeException {
    public BuscaAlunoPorClassificacaoENotaException() {
        super("Erro ao tentar buscar aluno por classificacao e nota");
    }
}
