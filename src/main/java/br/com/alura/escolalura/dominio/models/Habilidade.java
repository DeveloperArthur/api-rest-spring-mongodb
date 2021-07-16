package br.com.alura.escolalura.dominio.models;

import br.com.alura.escolalura.dominio.tratamentoexception.habilidade.exception.CamposObrigatoriosHabilidadeException;

public class Habilidade {
    private String nome;
    private String nivel;

    public Habilidade() {
    }

    public Habilidade(String nome, String nivel) {
        validaCampos(nome, nivel);
        this.nome = nome;
        this.nivel = nivel;
    }

    private void validaCampos(String nome, String nivel) {
        if (nome == "" || nome == null || nivel == "" || nivel == null)
            throw new CamposObrigatoriosHabilidadeException();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Habilidade{" +
                "nome='" + nome + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}