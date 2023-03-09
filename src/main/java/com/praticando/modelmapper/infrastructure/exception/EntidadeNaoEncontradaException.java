package com.praticando.modelmapper.infrastructure.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(String message){
        super(message);
    }
}
