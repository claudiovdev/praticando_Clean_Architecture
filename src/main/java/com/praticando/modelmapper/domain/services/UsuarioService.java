package com.praticando.modelmapper.domain.services;

import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;

import java.util.List;

public interface UsuarioService {

    public UsuarioDomain cadastrar(UsuarioDomain usuarioDomain);

    UsuarioDomain buscarPorId(String usuarioId);

    List<UsuarioDomain> filtroPersonalizado(String email, StatusUsuario status);

    List<UsuarioDomain> buscarTodos();
}
