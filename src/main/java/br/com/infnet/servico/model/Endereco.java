package br.com.infnet.servico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Endereco {
    private String endereco;
    private Long numeroEndereco;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

}
