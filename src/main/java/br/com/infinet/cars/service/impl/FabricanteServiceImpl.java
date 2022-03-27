package br.com.infinet.cars.service.impl;

import br.com.infinet.cars.model.Fabricante;
import br.com.infinet.cars.service.FabricanteService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class FabricanteServiceImpl implements FabricanteService {
    @Override
    public Fabricante getByNome(String nome) throws IOException, InterruptedException {
        Gson gson = new Gson();

        String url = String.format("http://localhost:8081/fabricante/nome/%s", nome);
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Fabricante fabricante = gson.fromJson(response.body(), Fabricante.class);
        return fabricante;

    }
}
