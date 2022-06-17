package br.com.infnet.servico.service.impl;

import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.repository.PessoaRepository;
import br.com.infnet.servico.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public void incluir(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    @Override
    public void alterar(Long id, Pessoa pessoa) {
        Pessoa pessoaSalvo = pessoaRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(pessoa, pessoaSalvo, "id");
        pessoaRepository.save(pessoaSalvo);
    }

    @Override
    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public Optional<Pessoa> buscarPeloId(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }
}
