package com.praticando.modelmapper.api.models.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioModelRequest {

    private String nome;

    private String email;

    private String telefone;

}
