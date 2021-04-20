package br.com.alura.escolalura.web.controllers;

import br.com.alura.escolalura.dominio.models.Aluno;
import br.com.alura.escolalura.dominio.models.Habilidade;
import br.com.alura.escolalura.dominio.services.AlunoService;
import br.com.alura.escolalura.web.dto.AlunoDto;
import br.com.alura.escolalura.web.form.HabilidadeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/habilidades")
public class HabilidadeController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/aluno/{idDoAluno}")
    public ResponseEntity<AlunoDto> salvar(@PathVariable String idDoAluno, @RequestBody HabilidadeForm habilidadeForm) {
        Habilidade habilidade = habilidadeForm.converte();
        Optional<Aluno> optionalAluno = alunoService.buscaPorId(idDoAluno);
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            Aluno alunoComHabilidade = aluno.adicionaHabilidade(habilidade);
            Aluno AlunoAtualizado = alunoService.salvar(alunoComHabilidade);
            return ResponseEntity.ok(new AlunoDto(AlunoAtualizado));
        }

        return ResponseEntity.notFound().build();
    }

}
