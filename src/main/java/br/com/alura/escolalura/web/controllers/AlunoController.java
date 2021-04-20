package br.com.alura.escolalura.web.controllers;

import br.com.alura.escolalura.dominio.models.Aluno;
import br.com.alura.escolalura.dominio.services.AlunoService;
import br.com.alura.escolalura.web.dto.AlunoDto;
import br.com.alura.escolalura.web.form.AlunoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDto> salvar(@RequestBody AlunoForm alunoForm) {
        Aluno aluno = alunoForm.converte();
        Aluno alunoSalvo = alunoService.salvar(aluno);
        return ResponseEntity.ok(new AlunoDto(alunoSalvo));
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> listar() {
        List<Aluno> alunos = alunoService.lista();
        return ResponseEntity.ok(alunos.stream().map(AlunoDto::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> buscaPorId(@PathVariable String id) {
        Optional<Aluno> optionalAluno = alunoService.buscaPorId(id);
        if (optionalAluno.isPresent())
            return ResponseEntity.ok(new AlunoDto(optionalAluno.get()));
        
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/busca")
    public ResponseEntity<List<AlunoDto>> buscaPorNome(@RequestParam("nome") String nome) {
        List<Aluno> alunos = alunoService.buscaPorNome(nome);
        return ResponseEntity.ok(alunos.stream().map(AlunoDto::new).collect(Collectors.toList()));
    }
}
