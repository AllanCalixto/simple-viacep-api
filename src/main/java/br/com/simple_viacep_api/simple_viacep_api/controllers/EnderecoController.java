package br.com.simple_viacep_api.simple_viacep_api.controllers;

import br.com.simple_viacep_api.simple_viacep_api.models.records.Endereco;
import br.com.simple_viacep_api.simple_viacep_api.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cep")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getEndereco(@PathVariable String cep) {
        return ResponseEntity.ok(enderecoService.getEndereco(cep));
    }
}
