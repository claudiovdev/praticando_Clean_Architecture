package com.praticando.modelmapper.domain.services.impl;

import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.domain.getway.UsuarioGateway;
import com.praticando.modelmapper.domain.services.UsuarioService;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioGateway usuarioGateway;


    @Override
    public UsuarioDomain cadastrar(UsuarioDomain usuarioDomain) {
        return usuarioGateway.cadastrar(usuarioDomain);
    }

    @Override
    public UsuarioDomain buscarPorId(String usuarioId) {
        return usuarioGateway.buscarporId(usuarioId);
    }

    @Override
    public List<UsuarioDomain> filtroPersonalizado(String email, StatusUsuario status) {
        return usuarioGateway.filtroPersonalizado(email, status);
    }

    @Override
    public List<UsuarioDomain> buscarTodos() {
        return usuarioGateway.buscarTodosUsuarios();
    }
}
