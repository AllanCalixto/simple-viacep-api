package br.com.simple_viacep_api.simple_viacep_api.exceptions;

import br.com.simple_viacep_api.simple_viacep_api.models.records.Endereco;

public class CepInvalidoException extends RuntimeException {

    private String mensagem;

    public CepInvalidoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }

}
