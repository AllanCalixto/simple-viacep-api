package br.com.simple_viacep_api.simple_viacep_api.exceptions;


public class EnderecoNaoEncontradoException extends RuntimeException {
    public EnderecoNaoEncontradoException(String mensagem) {
        super("Endereço não encontrado!");
    }
}
