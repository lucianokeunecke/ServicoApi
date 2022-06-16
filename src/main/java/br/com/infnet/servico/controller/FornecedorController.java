package br.com.infnet.servico.controller;

import br.com.infnet.servico.model.Cliente;
import br.com.infnet.servico.model.Fornecedor;
import br.com.infnet.servico.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    FornecedorService fornecedorService;

    @GetMapping("/{id}")
    public ResponseEntity< ? > listarPeloId(@PathVariable Long id){

        Optional<Fornecedor> fornecedor = fornecedorService.buscarPeloId(id);

        if(fornecedor.isPresent()){
            return ResponseEntity.ok().body(fornecedor);
        }
        return ResponseEntity.notFound().build();
    }
}
