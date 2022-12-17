package com.praticando.modelmapper.infrastructure.implementation;

import com.praticando.modelmapper.api.models.request.UsuarioModelRequest;
import com.praticando.modelmapper.api.models.response.UsuarioModelResponse;
import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.domain.getway.UsuarioGateway;
import com.praticando.modelmapper.infrastructure.entities.UsuarioEntity;
import com.praticando.modelmapper.infrastructure.mapper.UsuarioMapper;
import com.praticando.modelmapper.infrastructure.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioDataProvider implements UsuarioGateway {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioMapper usuarioMapper;


    @Override
    public UsuarioDomain cadastrar(UsuarioDomain usuario) {
        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuario);
        usuarioRepository.save(usuarioEntity);
        usuario = usuarioMapper.toDomain(usuarioEntity);
        return usuario;
    }
}
