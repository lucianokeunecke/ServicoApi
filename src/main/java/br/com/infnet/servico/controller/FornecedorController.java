package br.com.infnet.servico.controller;

import br.com.infnet.servico.model.Cliente;
import br.com.infnet.servico.model.Fornecedor;
import br.com.infnet.servico.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    FornecedorService fornecedorService;

    @PostMapping
    public void incluir(@RequestBody Fornecedor fornecedor){
        fornecedorService.incluir(fornecedor);
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable  Long id, @RequestBody Fornecedor fornecedor){
        fornecedorService.alterar(id, fornecedor);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable  Long id){
        fornecedorService.excluir(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity< ? > listarPeloId(@PathVariable Long id){

        Optional<Fornecedor> fornecedor = fornecedorService.buscarPeloId(id);

        if(fornecedor.isPresent()){
            return ResponseEntity.ok().body(fornecedor);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarTodos(){
        List<Fornecedor> all = fornecedorService.buscarTodos();
        return ResponseEntity.ok().body(all);
    }
}
