package com.praticando.modelmapper.infrastructure.repositories;

import com.praticando.modelmapper.infrastructure.entities.UsuarioEntity;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;

import java.util.List;

public interface UsuarioRepositoryQueues {
    List<UsuarioEntity> find(String email, StatusUsuario status);
}
