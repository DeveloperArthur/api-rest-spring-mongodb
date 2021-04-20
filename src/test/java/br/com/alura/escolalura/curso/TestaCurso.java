package br.com.alura.escolalura.curso;

import br.com.alura.escolalura.dominio.models.Curso;
import br.com.alura.escolalura.dominio.tratamentoexception.curso.exception.CamposObrigatoriosCursoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestaCurso {

    @Test
    public void naoDevePermitirCriarCursoSemCamposObrigatorios() {
        assertThrows(CamposObrigatoriosCursoException.class, () -> {
            Curso curso = new Curso(null);
        });
    }
}
