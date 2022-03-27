package br.com.infinet.cars.service.impl;

import br.com.infinet.cars.model.Fabricante;
import br.com.infinet.cars.service.FabricanteService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class FabricanteServiceImpl implements FabricanteService {
    @Override
    public Fabricante getByNome(String nome) throws IOException, InterruptedException {
        String url = String.format("http://localhost:8081/fabricante/nome/%s", nome);
        RestTemplate restTemplate = new RestTemplate();
        Fabricante fabricante = restTemplate.getForObject(url, Fabricante.class);

        return fabricante;

    }
}
