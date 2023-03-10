package com.praticando.modelmapper.domain.getway;
import com.praticando.modelmapper.domain.domain.UsuarioDomain;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UsuarioGateway {

    UsuarioDomain cadastrar(UsuarioDomain usuario);

    UsuarioDomain buscarporId(String usuarioId);

    List<UsuarioDomain> filtroPersonalizado(String email, StatusUsuario status);

    List<UsuarioDomain> buscarTodosUsuarios();
}
