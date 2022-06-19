package br.com.infnet.servico.validation.impl;

import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.repository.PessoaRepository;
import br.com.infnet.servico.validation.PessoaValidation;

public class CnpjCpfPessoaJaCadastradoValidationImpl implements PessoaValidation {

    private PessoaRepository pessoaRepository;

    public CnpjCpfPessoaJaCadastradoValidationImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void validar(Pessoa pessoa) {

        if (pessoaRepository.findByCnpjCpf(pessoa.getCnpjCpf()).orElse(null) != null) {
            if (pessoa.EhPessoaFisica()) {
                throw new RuntimeException("CPF já cadastrado.");
            }
            throw new RuntimeException("CNPJ já cadastrado.");
        }
    }
}
