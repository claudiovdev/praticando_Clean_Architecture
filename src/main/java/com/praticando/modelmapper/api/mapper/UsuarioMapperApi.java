package com.praticando.modelmapper.api.mapper;

import com.praticando.modelmapper.api.models.request.UsuarioModelRequest;
import com.praticando.modelmapper.api.models.response.UsuarioModelResponse;
import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UsuarioMapperApi {

    @Autowired
    private ModelMapper mapper;

    public UsuarioModelResponse toResponse(UsuarioDomain usuarioDomain){
        UsuarioModelResponse usuarioModelResponse = mapper.map(usuarioDomain, UsuarioModelResponse.class);
        return usuarioModelResponse;
    }

    public UsuarioDomain toDomain(UsuarioModelRequest usuarioModelRequest){
        UsuarioDomain usuarioDomain = mapper.map(usuarioModelRequest, UsuarioDomain.class);
        return usuarioDomain;
    }

    public List<UsuarioModelResponse> toResponseList(List<UsuarioDomain> usuarioDomainList) {
        return usuarioDomainList.stream().map(usuarioDomain -> toResponse(usuarioDomain)).collect(Collectors.toList());
    }
}
