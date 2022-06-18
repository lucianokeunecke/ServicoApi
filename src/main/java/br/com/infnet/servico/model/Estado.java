package br.com.infnet.servico.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Getter
@Setter
public class Estado {
    private String estado;
}
