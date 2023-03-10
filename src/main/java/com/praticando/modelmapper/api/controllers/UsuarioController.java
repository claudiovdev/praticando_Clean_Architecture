package com.praticando.modelmapper.api.controllers;

import com.praticando.modelmapper.api.mapper.UsuarioMapperApi;
import com.praticando.modelmapper.api.models.request.UsuarioModelRequest;
import com.praticando.modelmapper.api.models.response.UsuarioModelResponse;
import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.domain.getway.UsuarioGateway;
import com.praticando.modelmapper.domain.services.UsuarioService;
import com.praticando.modelmapper.infrastructure.entities.UsuarioEntity;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;
import com.praticando.modelmapper.infrastructure.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {


    @Autowired
   private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository repository;


    @Autowired
    private UsuarioMapperApi mapperApi;

    @PostMapping
    public ResponseEntity<UsuarioModelResponse>  cadastrarUsuario(@RequestBody UsuarioModelRequest usuarioModelRequest){
        UsuarioDomain usuario = mapperApi.toDomain(usuarioModelRequest);
       usuario =  usuarioService.cadastrar(usuario);
        UsuarioModelResponse usuarioModelResponse =  mapperApi.toResponse(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModelResponse);
    }

    @GetMapping("buscar/{usuarioId}")
    public ResponseEntity<UsuarioModelResponse> buscarUsuario(@PathVariable String usuarioId){
        UsuarioDomain usuario = usuarioService.buscarPorId(usuarioId);
        UsuarioModelResponse usuarioModelResponse = mapperApi.toResponse(usuario);
        return ResponseEntity.ok().body(usuarioModelResponse);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModelResponse>> listarUsuarios(){
        List<UsuarioDomain> usuarioDomainList = usuarioService.buscarTodos();
        List<UsuarioModelResponse> usuarioModelResponseList = mapperApi.toResponseList(usuarioDomainList);
        return ResponseEntity.ok().body(usuarioModelResponseList);
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<UsuarioModelResponse>> filtrarEmailStatus(String email, StatusUsuario status){
        List<UsuarioDomain> usuarioDomainList = usuarioService.filtroPersonalizado(email, status);
        List<UsuarioModelResponse> usuarioModelResponseList = mapperApi.toResponseList(usuarioDomainList);
        return ResponseEntity.ok().body(usuarioModelResponseList);
    }

}
