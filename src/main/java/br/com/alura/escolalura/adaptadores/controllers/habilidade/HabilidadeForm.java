package br.com.alura.escolalura.adaptadores.controllers.habilidade;

import br.com.alura.escolalura.dominio.models.Habilidade;

public class HabilidadeForm {
    private String nome;
    private String nivel;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Habilidade converte() {
        return new Habilidade(this.nome, this.nivel);
    }
}
