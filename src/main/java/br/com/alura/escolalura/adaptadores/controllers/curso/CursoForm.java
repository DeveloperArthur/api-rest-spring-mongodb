package br.com.alura.escolalura.adaptadores.controllers.curso;

import br.com.alura.escolalura.dominio.models.Curso;

public class CursoForm {
    private String nome;

    public Curso converte() {
        return new Curso(this.nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
