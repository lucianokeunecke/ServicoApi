package br.com.infnet.servico.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
}
