package br.com.infinet.pessoa.service;

import br.com.infinet.pessoa.model.Carro;

import java.util.List;
import java.util.Optional;

public interface CarroService {
     void insert(Carro carro);
     void delete(Long id);
     Optional<Carro> getById(Long id);
     List<Carro> getAll();
     List<Carro> top3();

}
