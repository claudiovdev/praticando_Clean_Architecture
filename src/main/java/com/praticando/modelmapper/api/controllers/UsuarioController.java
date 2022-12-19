package com.praticando.modelmapper.api.controllers;

import com.praticando.modelmapper.api.mapper.UsuarioMapperApi;
import com.praticando.modelmapper.api.models.request.UsuarioModelRequest;
import com.praticando.modelmapper.api.models.response.UsuarioModelResponse;
import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.domain.getway.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioGateway usuarioGateway;


    @Autowired
    private UsuarioMapperApi mapperApi;

    @PostMapping
    public UsuarioModelResponse cadastrarUsuario(@RequestBody UsuarioModelRequest usuarioModelRequest){
        UsuarioDomain usuario = mapperApi.toDomain(usuarioModelRequest);
        UsuarioDomain atualizado = usuarioGateway.cadastrar(usuario);
        UsuarioModelResponse usuarioModelResponse =  mapperApi.toResponse(atualizado);
        return usuarioModelResponse;
    }
}
