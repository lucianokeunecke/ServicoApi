package br.com.infnet.servico.service.impl;

import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.repository.PessoaRepository;
import br.com.infnet.servico.service.PessoaService;
import br.com.infnet.servico.validation.PessoaValidation;
import br.com.infnet.servico.validation.impl.CNPJPessoaValidationImpl;
import br.com.infnet.servico.validation.impl.CNPJJaCadastradoValidationImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public void incluir(Pessoa pessoa) {
        pessoaEhValida(pessoa);

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

    private void pessoaEhValida(Pessoa pessoa) {
        List<PessoaValidation> listaValidacoes = new ArrayList<>();
        listaValidacoes.add(new CNPJPessoaValidationImpl());
        listaValidacoes.add(new CNPJJaCadastradoValidationImpl(pessoaRepository));

        for (PessoaValidation validacao: listaValidacoes) {
            validacao.validar(pessoa);
        }
    }
}
