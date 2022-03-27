package br.com.infinet.cars.controller;

import br.com.infinet.cars.model.Carro;
import br.com.infinet.cars.model.CarroDTO;
import br.com.infinet.cars.model.Fabricante;
import br.com.infinet.cars.service.CarroService;
import br.com.infinet.cars.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.SplittableRandom;

@RestController
@RequestMapping("/cars")
public class CarroController {
    @Autowired
    CarroService carroService;
    @Autowired
    FabricanteService fabricanteService;
    @GetMapping
    public ResponseEntity<List<Carro>> getAll(){
        SplittableRandom random = new SplittableRandom();
        int i = random.nextInt(1000);
        if(i > 900){
            throw new RuntimeException("Um Erro Ocorreu");
        }
        List<Carro> all = carroService.getAll();
        return ResponseEntity.ok().body(all);

    }
    @GetMapping("/{id}")
    public ResponseEntity< ? > getById(@PathVariable  Long id){
        Optional<Carro> byId = carroService.getById(id);
        SplittableRandom random = new SplittableRandom();

        int i = random.nextInt(1000);
        if(i > 900){
            throw new RuntimeException("Um Erro Ocorreu");
        }
        if(byId.isPresent()){
            Carro carro = byId.get();
            try {
                Fabricante byNome = fabricanteService.getByNome(carro.getFabricante());
                CarroDTO build = CarroDTO.builder().fabricante(byNome).carro(carro).build();
                return ResponseEntity.ok().body(build);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.notFound().build();

    }
    @PostMapping
    public void create(@RequestBody  Carro carro){
        carroService.insert(carro);
    }
    @GetMapping("/top3")
    public ResponseEntity<List<Carro>> top3(){
        SplittableRandom random = new SplittableRandom();
        int i = random.nextInt(1000);
        if(i > 900){
            throw new RuntimeException("Um Erro Ocorreu");
        }
        List<Carro> carros = carroService.top3();
        return ResponseEntity.ok().body(carros);

    }
}
