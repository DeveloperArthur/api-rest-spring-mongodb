package br.com.alura.escolalura.dominio.services;

import br.com.alura.escolalura.dominio.Classificacao;
import br.com.alura.escolalura.dominio.models.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoService {
    Aluno salvar(Aluno aluno);

    List<Aluno> lista();

    Optional<Aluno> buscaPorId(String id);

    List<Aluno> buscaPorNome(String nome);

    List<Aluno> buscaPor(Classificacao classificacao, double nota);
}
