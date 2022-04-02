package br.com.infinet.pessoa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class Cidade {
    private String id;
    private String nome;
    private String estado;
}
