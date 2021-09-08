package com.br.ifspapi.post.exceptions;


public class DataIntegrityViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationException (String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegrityViolationException (String mensagem) {
        super(mensagem);
    }
}
