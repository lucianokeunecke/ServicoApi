package br.com.infinet.cars.service;

import br.com.infinet.cars.model.Carro;

import java.util.List;
import java.util.Optional;

public interface CarroService {
     void insert(Carro carro);
     void delete(Long id);
     Optional<Carro> getById(Long id);
     List<Carro> getAll();
     List<Carro> top3();

}
