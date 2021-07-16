package br.com.alura.escolalura.dominio.models;

import br.com.alura.escolalura.dominio.tratamentoexception.aluno.exception.CamposObrigatoriosAlunoException;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno {
    private ObjectId id;
    private String nome;
    private Date dataDeNascimento;
    private Curso curso;
    private List<Nota> notas;
    private List<Habilidade> habilidades;

    public Aluno() {
    }

    public Aluno(ObjectId id, String nome, Date dataDeNascimento, Curso curso) {
        validaCampos(nome, dataDeNascimento);
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.curso = curso;
    }

    public Aluno(String nome, Date dataDeNascimento, Curso curso) {
        validaCampos(nome, dataDeNascimento);
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.curso = curso;
    }

    private void validaCampos(String nome, Date dataDeNascimento) {
        if (nome == "" || nome == null || dataDeNascimento == null)
            throw new CamposObrigatoriosAlunoException();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Nota> getNotas() {
        if (notas == null) notas = new ArrayList<>();
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Habilidade> getHabilidades() {
        if (habilidades == null) habilidades = new ArrayList<>();
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", curso=" + curso +
                ", notas=" + notas +
                ", habilidades=" + habilidades +
                '}';
    }

    public Aluno criarId() {
        setId(new ObjectId());
        return this;
    }

    public Aluno adicionaHabilidade(Habilidade habilidade) {
        List<Habilidade> habilidades = this.getHabilidades();
        habilidades.add(habilidade);
        this.setHabilidades(habilidades);
        return this;
    }

    public Aluno adicionaNota(Nota nota) {
        List<Nota> notas = this.getNotas();
        notas.add(nota);
        this.setNotas(notas);
        return this;
    }
}