package com.praticando.modelmapper.infrastructure.implementation;

import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.domain.getway.UsuarioGateway;
import com.praticando.modelmapper.infrastructure.entities.UsuarioEntity;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;
import com.praticando.modelmapper.infrastructure.exception.EntidadeNaoEncontradaException;
import com.praticando.modelmapper.infrastructure.mapper.UsuarioMapper;
import com.praticando.modelmapper.infrastructure.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioDataProvider implements UsuarioGateway {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;


    @Override
    public UsuarioDomain cadastrar(UsuarioDomain usuario) {
        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuario);
        usuario = usuarioMapper.toDomain(usuarioRepository.save(usuarioEntity));
        return usuario;
    }

    @Override
    public UsuarioDomain buscarporId(String usuarioId) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(usuarioId).orElseThrow(() -> new EntidadeNaoEncontradaException("Usuario não encontrado"));
        return usuarioMapper.toDomain(usuarioEntity);
    }

    @Override
    public List<UsuarioDomain> filtroPersonalizado(String email, StatusUsuario status) {
        List<UsuarioEntity> usuarioEntityList = usuarioRepository.find(email, status);
        List<UsuarioDomain> usuarioDomainList = usuarioMapper.toDomainList(usuarioEntityList);
        return usuarioDomainList;
    }

    @Override
    public List<UsuarioDomain> buscarTodosUsuarios() {
        List<UsuarioEntity> usuarioEntityList =  usuarioRepository.findAll();
        List<UsuarioDomain> usuarioDomainList = usuarioMapper.toDomainList(usuarioEntityList);
        return usuarioDomainList;
    }
}
