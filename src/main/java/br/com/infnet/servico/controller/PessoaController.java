package br.com.infnet.servico.controller;

import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public void incluir(@RequestBody Pessoa pessoa){
        pessoaService.incluir(pessoa);
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable  Long id, @RequestBody Pessoa pessoa){
        pessoaService.alterar(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable  Long id){
        pessoaService.excluir(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity< ? > listarPeloId(@PathVariable Long id){

        Optional<Pessoa> pessoa = pessoaService.buscarPeloId(id);

        if(pessoa.isPresent()){
            return ResponseEntity.ok().body(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodos(){
        List<Pessoa> all = pessoaService.buscarTodos();
        return ResponseEntity.ok().body(all);
    }
}