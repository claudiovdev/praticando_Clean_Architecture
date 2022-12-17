package com.praticando.modelmapper.domain.getway;

import com.praticando.modelmapper.api.models.request.UsuarioModelRequest;
import com.praticando.modelmapper.api.models.response.UsuarioModelResponse;
import com.praticando.modelmapper.domain.domain.UsuarioDomain;

public interface UsuarioGateway {

    UsuarioDomain cadastrar(UsuarioDomain usuario);
}
