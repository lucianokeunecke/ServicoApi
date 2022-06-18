package br.com.infnet.servico.validation.impl;

import br.com.infnet.servico.enumerator.EnumTipoPessoa;
import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.repository.PessoaRepository;
import br.com.infnet.servico.validation.PessoaValidation;
import org.springframework.beans.factory.annotation.Autowired;

public class CNPJJaCadastradoValidationImpl implements PessoaValidation {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void validar(Pessoa pessoa) {
        if (pessoa.getTipoPessoa().getId() == EnumTipoPessoa.PESSOA_JURIFICA.getValor()) {
            Pessoa pessoaSalva = pessoaRepository.findByCnpjCpf(pessoa.getCnpjCpf()).orElse(null);
            /*if (pessoaSalva != null) {
                throw new RuntimeException("CNPJ já cadastrado.");
            }*/
        }
    }
}
