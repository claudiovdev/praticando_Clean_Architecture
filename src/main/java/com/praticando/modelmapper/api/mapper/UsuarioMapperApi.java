package com.praticando.modelmapper.api.mapper;

import com.praticando.modelmapper.api.models.request.UsuarioModelRequest;
import com.praticando.modelmapper.api.models.response.UsuarioModelResponse;
import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import org.modelmapper.ModelMapper;

public class UsuarioMapperApi {

    private ModelMapper mapper;

    public UsuarioModelResponse toResponse(UsuarioDomain usuarioDomain){
        return mapper.map(usuarioDomain, UsuarioModelResponse.class);
    }

    public UsuarioDomain toDomain(UsuarioModelRequest usuarioModelRequest){
        return mapper.map(usuarioModelRequest, UsuarioDomain.class);
    }
}
