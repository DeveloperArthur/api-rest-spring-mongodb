package br.com.alura.escolalura.dominio.models;

import br.com.alura.escolalura.dominio.tratamentoexception.curso.exception.CamposObrigatoriosCursoException;

public class Curso {
    private String nome;

    public Curso() {
    }

    public Curso(String nomeCurso) {
        validaCampos(nomeCurso);
        this.nome = nomeCurso;
    }

    private void validaCampos(String nomeCurso) {
        if (nomeCurso == "" || nomeCurso == null)
            throw new CamposObrigatoriosCursoException();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
