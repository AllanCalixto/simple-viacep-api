package br.com.simple_viacep_api.simple_viacep_api.services;

import br.com.simple_viacep_api.simple_viacep_api.exceptions.ErroGeracaoJsonException;
import br.com.simple_viacep_api.simple_viacep_api.models.records.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class GeradorJsonService {

    public void salvarJson(Endereco endereco) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter escrever = new FileWriter(endereco.cep() + ".json");
            escrever.write(gson.toJson(endereco));
            escrever.close();
        } catch (IOException e) {
            throw new ErroGeracaoJsonException("Erro ao salvar o JSON do endereço!");
        }
    }
}
