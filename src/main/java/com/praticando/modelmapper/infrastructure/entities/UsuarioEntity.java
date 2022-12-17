package com.praticando.modelmapper.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TB_Usuarios")
public class UsuarioEntity {

    @Id
    private String id;

    private String nome;

    private String email;

    private String telefone;

    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataCadastro;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataAtualização;




}
