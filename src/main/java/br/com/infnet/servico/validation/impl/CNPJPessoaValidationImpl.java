package br.com.infnet.servico.validation.impl;

import br.com.infnet.servico.enumerator.EnumTipoPessoa;
import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.validation.PessoaValidation;

public class CNPJPessoaValidationImpl implements PessoaValidation {
    @Override
    public void validar(Pessoa fornecedor) {
        if (fornecedor.getTipoPessoa().getId() == EnumTipoPessoa.PESSOA_JURIFICA.getValor()) {
            if (fornecedor.getCnpjCpf().length() != 18) {
                throw new RuntimeException("CNPJ inválido.");
            }
        }
    }
}
