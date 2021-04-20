package br.com.alura.escolalura.dominio.services;

import br.com.alura.escolalura.dominio.Classificacao;
import br.com.alura.escolalura.dominio.models.Aluno;
import br.com.alura.escolalura.dominio.tratamentoexception.aluno.exception.*;
import br.com.alura.escolalura.infra.mongo.repositorys.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {
    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno salvar(Aluno aluno) {
        try {
            return alunoRepository.salvar(aluno);
        } catch (SalvarAlunoException e) {
            throw new SalvarAlunoException();
        }
    }

    @Override
    public List<Aluno> lista() {
        try {
            return alunoRepository.lista();
        } catch (ListaAlunoException e) {
            throw new ListaAlunoException();
        }
    }

    @Override
    public Optional<Aluno> buscaPorId(String id) {
        try {
            return alunoRepository.buscaPorId(id);
        } catch (BuscaAlunoPorIdException e) {
            throw new BuscaAlunoPorIdException();
        }
    }

    @Override
    public List<Aluno> buscaPorNome(String nome) {
        try {
            return alunoRepository.buscaPorNome(nome);
        } catch (BuscaAlunoPorNomeException e) {
            throw new BuscaAlunoPorNomeException();
        }
    }

    @Override
    public List<Aluno> buscaPor(Classificacao classificacao, double nota) {
        try {
            return alunoRepository.buscaPor(classificacao, nota);
        } catch (BuscaAlunoPorClassificacaoENotaException e) {
            throw new BuscaAlunoPorClassificacaoENotaException();
        }
    }
}
