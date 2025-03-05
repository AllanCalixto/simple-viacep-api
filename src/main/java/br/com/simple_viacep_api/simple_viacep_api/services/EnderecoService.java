package br.com.simple_viacep_api.simple_viacep_api.services;

import br.com.simple_viacep_api.simple_viacep_api.exceptions.CepInvalidoException;
import br.com.simple_viacep_api.simple_viacep_api.models.records.Endereco;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class EnderecoService {

    @Autowired
    GeradorJsonService geradorJsonService;

    public Endereco getEndereco(String cep) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            // Valida se o CEP tem 8 caracteres e é composto apenas por números.
            if (!cep.matches("\\d{8}")) {
                throw new IOException();
            }

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Endereco enderecoObj = new Gson().fromJson(response.body(), Endereco.class);
            if (enderecoObj.cep() != null) {
                geradorJsonService.salvarJson(enderecoObj);
            }

            return enderecoObj;

        } catch (IOException | InterruptedException | IllegalStateException e) {
            throw new CepInvalidoException("Um erro ocorreu. Verifique o CEP e tente novamente.");
        }
    }
}
