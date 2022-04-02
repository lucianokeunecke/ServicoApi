package br.com.infinet.pessoa.service.impl;

import br.com.infinet.pessoa.model.Carro;
import br.com.infinet.pessoa.repository.CarroRepository;
import br.com.infinet.pessoa.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {
    @Autowired
    CarroRepository carroRepository;

    @Override
    @CacheEvict(cacheNames = "Cars", allEntries = true)
    public void insert(Carro carro) {
        carroRepository.save(carro);
    }
    @Override
    public void delete(Long id) {
        carroRepository.deleteById(id);
    }
    @Override
    public Optional<Carro> getById(Long id) {
         return carroRepository.findById(id);
    }
    @Override
    public List<Carro> getAll() {
        return carroRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "Cars", key="#root.method.name")
    public List<Carro> top3() {

        return carroRepository.findAll(PageRequest.of(0, 3,
                Sort.by(Sort.Direction.DESC, "velocidadeMaxima"))).getContent();
    }
}
