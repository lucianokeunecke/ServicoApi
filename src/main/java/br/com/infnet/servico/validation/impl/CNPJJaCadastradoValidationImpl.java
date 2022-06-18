package br.com.infnet.servico.validation.impl;

import br.com.infnet.servico.enumerator.EnumTipoPessoa;
import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.repository.PessoaRepository;
import br.com.infnet.servico.validation.PessoaValidation;

public class CNPJJaCadastradoValidationImpl implements PessoaValidation {

    private PessoaRepository pessoaRepository;

    public CNPJJaCadastradoValidationImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void validar(Pessoa pessoa) {
        if (pessoa.getTipoPessoa().getId() == EnumTipoPessoa.PESSOA_JURIFICA.getValor()) {
            if (pessoaRepository.findByCnpjCpf(pessoa.getCnpjCpf()) != null) {
                throw new RuntimeException("CNPJ já cadastrado.");
            }
        }
    }
}
