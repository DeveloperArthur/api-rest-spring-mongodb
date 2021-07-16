package br.com.alura.escolalura.habilidade;

import br.com.alura.escolalura.dominio.models.Habilidade;
import br.com.alura.escolalura.dominio.tratamentoexception.habilidade.exception.CamposObrigatoriosHabilidadeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestaHabilidade {

    @Test
    public void naoDevePermitirCriarHabilidadeSemCamposObrigatorios() {
        assertThrows(CamposObrigatoriosHabilidadeException.class, () -> {
            Habilidade habilidade = new Habilidade(null, "");
        });
    }
}
