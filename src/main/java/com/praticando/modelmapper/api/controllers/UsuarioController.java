package com.praticando.modelmapper.api.controllers;

import com.praticando.modelmapper.api.models.request.UsuarioModelRequest;
import com.praticando.modelmapper.api.models.response.UsuarioModelResponse;
import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.domain.getway.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioGateway usuarioGateway;

    public UsuarioModelResponse cadastrarUsuario(UsuarioModelRequest usuarioModelRequest){
        UsuarioDomain usuario = new UsuarioDomain();
        UsuarioDomain usuarioDomain =  usuarioGateway.cadastrar(usuario);
        UsuarioModelResponse usuarioModelResponse = null;
        return usuarioModelResponse;
    }
}
