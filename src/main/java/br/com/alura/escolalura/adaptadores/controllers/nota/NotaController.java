package br.com.alura.escolalura.adaptadores.controllers.nota;

import br.com.alura.escolalura.dominio.Classificacao;
import br.com.alura.escolalura.dominio.models.Aluno;
import br.com.alura.escolalura.dominio.models.Nota;
import br.com.alura.escolalura.usecases.AlunoService;
import br.com.alura.escolalura.adaptadores.controllers.aluno.dto.AlunoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/aluno/{idDoAluno}")
    public ResponseEntity<AlunoDto> salvar(@PathVariable String idDoAluno, @RequestBody NotaForm notaForm) {
        Nota nota = notaForm.converte();
        Optional<Aluno> optionalAluno = alunoService.buscaPorId(idDoAluno);
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            Aluno alunoComNota = aluno.adicionaNota(nota);
            Aluno alunoAtualizado = alunoService.salvar(alunoComNota);
            return ResponseEntity.ok(new AlunoDto(alunoAtualizado));
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/aluno/busca")
    public ResponseEntity<List<AlunoDto>> busca(@RequestParam("classificacao") Classificacao classificacao,
                                                @RequestParam("notacorte") String notaCorte) {
        List<Aluno> alunos = alunoService.buscaPor(classificacao, Double.parseDouble(notaCorte));
        return ResponseEntity.ok(alunos.stream().map(AlunoDto::new).collect(Collectors.toList()));
    }
}
