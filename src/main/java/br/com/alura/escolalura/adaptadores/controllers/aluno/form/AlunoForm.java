package br.com.alura.escolalura.adaptadores.controllers.aluno.form;

import br.com.alura.escolalura.adaptadores.controllers.curso.CursoForm;
import br.com.alura.escolalura.dominio.models.Aluno;
import br.com.alura.escolalura.dominio.models.Curso;
import org.bson.types.ObjectId;

import java.util.Date;

public class AlunoForm {
    private String id;
    private String nome;
    private Date dataDeNascimento;
    private CursoForm cursoForm;

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setCurso(CursoForm cursoForm) {
        this.cursoForm = cursoForm;
    }

    public Aluno converte() {
        Curso curso = this.cursoForm.converte();

        if (this.id == null)
            return new Aluno(this.nome, this.dataDeNascimento, curso);

        return new Aluno(new ObjectId(this.id),
                this.nome, this.dataDeNascimento, curso);
    }
}
