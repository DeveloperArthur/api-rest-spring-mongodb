package br.com.alura.escolalura.web.dto;

import br.com.alura.escolalura.dominio.models.Aluno;
import br.com.alura.escolalura.dominio.models.Curso;
import br.com.alura.escolalura.dominio.models.Habilidade;
import br.com.alura.escolalura.dominio.models.Nota;

import java.util.Date;
import java.util.List;

public class AlunoDto {
    private String id;
    private String nome;
    private Date dataDeNascimento;
    private Curso curso;
    private List<Nota> notas;
    private List<Habilidade> habilidades;

    public AlunoDto(Aluno aluno) {
        this.id = aluno.getId().toString();
        this.nome = aluno.getNome();
        this.dataDeNascimento = aluno.getDataDeNascimento();
        this.curso = aluno.getCurso();
        if (aluno.getNotas() != null) this.notas = aluno.getNotas();
        if (aluno.getHabilidades() != null) this.habilidades = aluno.getHabilidades();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }
}
