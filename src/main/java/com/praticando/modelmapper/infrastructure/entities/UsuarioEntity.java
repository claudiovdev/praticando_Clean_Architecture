package com.praticando.modelmapper.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataAtualização;




}
