package com.praticando.modelmapper.infrastructure.repositories;

import com.praticando.modelmapper.infrastructure.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String>, UsuarioRepositoryQueues {

}
