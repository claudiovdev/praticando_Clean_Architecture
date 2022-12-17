package com.praticando.modelmapper.api.models.response;


import java.time.LocalDateTime;

public class UsuarioModelResponse {

    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String status;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualização;
}
