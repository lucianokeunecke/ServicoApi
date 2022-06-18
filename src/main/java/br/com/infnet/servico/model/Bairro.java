package br.com.infnet.servico.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
public class Bairro {
    private String bairro;
    @Embedded
    private Cidade cidade;
}
