package com.praticando.modelmapper.domain.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioDomain {


    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String status;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualização;
}
