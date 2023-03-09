package com.praticando.modelmapper.domain.getway;
import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import org.springframework.stereotype.Component;



public interface UsuarioGateway {

    UsuarioDomain cadastrar(UsuarioDomain usuario);

    UsuarioDomain buscarporId(String usuarioId);
}
