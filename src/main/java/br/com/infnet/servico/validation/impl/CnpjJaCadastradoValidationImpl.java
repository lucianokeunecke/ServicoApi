package br.com.infnet.servico.validation.impl;

import br.com.infnet.servico.enumerator.EnumTipoPessoa;
import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.repository.PessoaRepository;
import br.com.infnet.servico.validation.PessoaValidation;

public class CnpjJaCadastradoValidationImpl implements PessoaValidation {

    private PessoaRepository pessoaRepository;

    public CnpjJaCadastradoValidationImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void validar(Pessoa pessoa) {
        if (!pessoa.EhPessoaJuridica()) return;
        if (pessoaRepository.findByCnpjCpf(pessoa.getCnpjCpf()).orElse(null) != null) {
            throw new RuntimeException("CNPJ já cadastrado.");
        }
    }
}
