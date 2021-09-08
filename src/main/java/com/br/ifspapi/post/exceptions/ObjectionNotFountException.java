package com.br.ifspapi.post.exceptions;

public class ObjectionNotFountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectionNotFountException (String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectionNotFountException (String message) {
        super(message);
    }
}