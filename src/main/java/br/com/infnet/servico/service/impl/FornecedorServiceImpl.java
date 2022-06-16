package br.com.infnet.servico.service.impl;

import br.com.infnet.servico.model.Cliente;
import br.com.infnet.servico.model.Fornecedor;
import br.com.infnet.servico.repository.FornecedorRepository;
import br.com.infnet.servico.service.FornecedorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {
    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public void incluir(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

    @Override
    public void alterar(Long id, Fornecedor fornecedor) {
        Fornecedor fornecedorSalvo = fornecedorRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(fornecedor, fornecedorSalvo, "id");
        fornecedorRepository.save(fornecedorSalvo);
    }

    @Override
    public void excluir(Long id) {
        fornecedorRepository.deleteById(id);
    }

    @Override
    public Optional<Fornecedor> buscarPeloId(Long id) {
        return fornecedorRepository.findById(id);
    }

    @Override
    public List<Fornecedor> buscarTodos() {
        return fornecedorRepository.findAll();
    }
}
