package br.com.simple_viacep_api.simple_viacep_api.exceptions;

public class ErroGeracaoJsonException extends RuntimeException {
    public ErroGeracaoJsonException(String mensagem) {
        super("Erro ao salvar o JSON do endereço");
    }
}
