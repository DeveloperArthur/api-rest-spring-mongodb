package br.com.alura.escolalura.dominio.models;

import br.com.alura.escolalura.dominio.tratamentoexception.nota.exception.CamposObrigatoriosNotaException;

public class Nota {
    private Double valor;

    public Nota() {

    }

    public Nota(Double valor) {
        validaCampos(valor);
        this.valor = valor;
    }

    private void validaCampos(Double valor) {
        if (valor == null)
            throw new CamposObrigatoriosNotaException();
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "valor=" + valor +
                '}';
    }
}
