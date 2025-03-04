package br.com.simple_viacep_api.simple_viacep_api.exceptions;

public class ErroGeracaoJsonException extends RuntimeException {

    private String mensagem;

    public ErroGeracaoJsonException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
