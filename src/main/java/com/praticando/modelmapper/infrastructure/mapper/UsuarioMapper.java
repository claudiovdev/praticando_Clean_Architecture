package com.praticando.modelmapper.infrastructure.mapper;

import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.infrastructure.entities.UsuarioEntity;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioMapper {

    @Autowired
    private ModelMapper mapper;

    public UsuarioEntity toEntity(UsuarioDomain usuario) {
        UsuarioEntity usuarioEntity = mapper.map(usuario, UsuarioEntity.class);
        usuarioEntity.setId(UUID.randomUUID().toString());
        usuarioEntity.setStatus(StatusUsuario.ATIVO);
        return usuarioEntity;
    }

    public UsuarioDomain toDomain(UsuarioEntity usuarioEntity) {
        return mapper.map(usuarioEntity, UsuarioDomain.class);
    }

}
