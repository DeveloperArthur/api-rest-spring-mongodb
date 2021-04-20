package br.com.alura.escolalura.web.form;

import br.com.alura.escolalura.dominio.models.Nota;

public class NotaForm {
    private Double valor;

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Nota converte() {
        return new Nota(this.valor);
    }
}
