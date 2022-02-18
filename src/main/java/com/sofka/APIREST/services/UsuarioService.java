package com.sofka.APIREST.services;

import java.util.ArrayList;
import java.util.Optional;

import com.sofka.APIREST.models.UsuarioModel;
import com.sofka.APIREST.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired  //Necesitamos esto para crear instancias
    UsuarioRepository usuarioRepository; //Creamos una instancia de UsuarioRepository
    
    //Obtiene los usuarios de la BD que retorna un array de usuarios
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    //Inserta (o guarda) un nuevo usuario
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }


    public ArrayList<UsuarioModel>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}