package com.praticando.modelmapper.infrastructure.repositories.impl;

import com.praticando.modelmapper.infrastructure.entities.UsuarioEntity;
import com.praticando.modelmapper.infrastructure.enums.StatusUsuario;
import com.praticando.modelmapper.infrastructure.repositories.UsuarioRepositoryQueues;
import org.springframework.util.StringUtils;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryQueuesImpl implements UsuarioRepositoryQueues {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<UsuarioEntity> find(String email, StatusUsuario status) {

        var builder = manager.getCriteriaBuilder();
        var criteria = builder.createQuery(UsuarioEntity.class);
        var root = criteria.from(UsuarioEntity.class);

        ArrayList<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(email)){
            predicates.add(builder.like(root.get("email"), "%" + email + "%"));
        }

        if(status != null){
            if(status.toString() == "ATIVO"){
                predicates.add(builder.equal(root.get("status"), StatusUsuario.ATIVO));
            }

            if(status.toString() == "INATIVO"){
               predicates.add(builder.equal(root.get("status"), StatusUsuario.INATIVO));
            }
        }

        criteria.where(predicates.toArray(new Predicate[0]));
        TypedQuery query = manager.createQuery(criteria);

        return query.getResultList();

    }
}
