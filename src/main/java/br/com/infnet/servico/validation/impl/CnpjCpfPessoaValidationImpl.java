package br.com.infnet.servico.validation.impl;

import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.validation.PessoaValidation;

public class CnpjCpfPessoaValidationImpl implements PessoaValidation {

    @Override
    public void validar(Pessoa pessoa) {
        if (pessoa.getCnpjCpf().length() != 14 && pessoa.getCnpjCpf().length() != 18) {
            throw new RuntimeException("CPF ou CNPJ inválido.");
        }
    }
}
