package com.praticando.modelmapper.domain.services.impl;

import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.domain.getway.UsuarioGateway;
import com.praticando.modelmapper.domain.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioGateway usuarioGateway;


    @Override
    public UsuarioDomain cadastrar(UsuarioDomain usuarioDomain) {
        return usuarioGateway.cadastrar(usuarioDomain);
    }
}
