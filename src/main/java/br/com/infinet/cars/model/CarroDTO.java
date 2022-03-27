package br.com.infinet.cars.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarroDTO {
    Carro carro;
    Fabricante fabricante;
}
