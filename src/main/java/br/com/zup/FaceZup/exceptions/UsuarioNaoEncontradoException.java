package br.com.zup.FaceZup.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
}
