package br.com.alura.escolalura.nota;

import br.com.alura.escolalura.dominio.models.Nota;
import br.com.alura.escolalura.dominio.tratamentoexception.nota.exception.CamposObrigatoriosNotaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestaNota {

    @Test
    public void naoDevePermitirCriarNotaSemCamposObrigatorios() {
        assertThrows(CamposObrigatoriosNotaException.class, () -> {
            Nota nota = new Nota(null);
        });
    }
}
