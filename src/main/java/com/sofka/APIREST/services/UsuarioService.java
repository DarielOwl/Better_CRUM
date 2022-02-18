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

    
    //Obtener un usuario dependiendo de su ID (El tipo "Optional" permite que no exista dicho ID, o sea nulo)
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    //Obtener el usuario por su prioridad 
    public ArrayList<UsuarioModel>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    //eliminar un usuario por su id
    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){ 
            return false;
        }
    }

}