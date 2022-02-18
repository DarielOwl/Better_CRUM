package com.sofka.APIREST.repositories;

import java.util.ArrayList;

import com.sofka.APIREST.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    //Crear funcion para que te devuelva usuarios dependiendo de la "prioridad"
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}