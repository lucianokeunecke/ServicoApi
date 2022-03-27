package br.com.infinet.cars.service;

import br.com.infinet.cars.model.Fabricante;

import java.io.IOException;

public interface FabricanteService {
    Fabricante getByNome(String fabricante) throws IOException, InterruptedException;
}
