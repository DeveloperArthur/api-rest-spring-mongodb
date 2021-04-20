package br.com.alura.escolalura.aluno;

import br.com.alura.escolalura.dominio.models.Aluno;
import br.com.alura.escolalura.dominio.models.Curso;
import br.com.alura.escolalura.dominio.tratamentoexception.aluno.exception.CamposObrigatoriosAlunoException;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestaAluno {

    @Test
    public void naoDevePermitirCriarAlunoSemCamposObrigatorios() {
        assertThrows(CamposObrigatoriosAlunoException.class, () -> {
            Aluno aluno = new Aluno(new ObjectId(), "",
                    null, new Curso());
        });
    }
}
