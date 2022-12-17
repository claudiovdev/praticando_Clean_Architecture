package com.praticando.modelmapper.api.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioModelRequest {

    private String nome;

    private String email;

    private String telefone;

}
