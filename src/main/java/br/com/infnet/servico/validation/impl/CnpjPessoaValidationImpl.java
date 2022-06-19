package br.com.infnet.servico.validation.impl;

import br.com.infnet.servico.enumerator.EnumTipoPessoa;
import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.validation.PessoaValidation;

public class CnpjPessoaValidationImpl implements PessoaValidation {
    @Override
    public void validar(Pessoa pessoa) {
        if (!pessoa.EhPessoaJuridica()) return;
        if (pessoa.getCnpjCpf().length() != 18) {
            throw new RuntimeException("CNPJ inválido.");
        }
    }
}
