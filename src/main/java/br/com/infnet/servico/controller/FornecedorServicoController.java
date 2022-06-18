package br.com.infnet.servico.controller;

import br.com.infnet.servico.model.FornecedorServico;
import br.com.infnet.servico.service.FornecedorServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedorServico")
public class FornecedorServicoController {

    @Autowired
    FornecedorServicoService fornecedorServicoService;

    @PostMapping
    public void incluir(@RequestBody FornecedorServico fornecedorServico){
        fornecedorServicoService.incluir(fornecedorServico);
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable  Long id, @RequestBody FornecedorServico fornecedorServico){
        fornecedorServicoService.alterar(id, fornecedorServico);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable  Long id){
        fornecedorServicoService.excluir(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity< ? > listarPeloId(@PathVariable Long id){

        Optional<FornecedorServico> fornecedorServico = fornecedorServicoService.buscarPeloId(id);

        if(fornecedorServico.isPresent()){
            return ResponseEntity.ok().body(fornecedorServico);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<FornecedorServico>> listarTodos(){
        List<FornecedorServico> all = fornecedorServicoService.buscarTodos();
        return ResponseEntity.ok().body(all);
    }

}
