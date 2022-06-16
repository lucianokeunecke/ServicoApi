package br.com.infnet.servico.controller;

import br.com.infnet.servico.model.Cliente;
import br.com.infnet.servico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos(){

        List<Cliente> all = clienteService.buscarTodos();

        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity< ? > listarPeloId(@PathVariable Long id){

        Optional<Cliente> cliente = clienteService.buscarPeloId(id);

        if(cliente.isPresent()){
            return ResponseEntity.ok().body(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public void incluir(@RequestBody Cliente cliente){

        clienteService.incluir(cliente);
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable  Long id, @RequestBody Cliente cliente){

        clienteService.alterar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable  Long id){

        clienteService.excluir(id);
    }

}
