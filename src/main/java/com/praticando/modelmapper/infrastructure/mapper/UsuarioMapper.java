package com.praticando.modelmapper.infrastructure.mapper;

import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.infrastructure.entities.UsuarioEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioMapper {

    @Autowired
    private ModelMapper mapper;

    public UsuarioEntity toEntity(UsuarioDomain usuario) {
        return mapper.map(usuario, UsuarioEntity.class);
    }

    public UsuarioDomain toDomain(UsuarioEntity usuarioEntity) {
        return mapper.map(usuarioEntity, UsuarioDomain.class);
    }

}
