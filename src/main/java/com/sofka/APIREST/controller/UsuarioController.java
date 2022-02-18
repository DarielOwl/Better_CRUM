package com.sofka.APIREST.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.sofka.APIREST.models.UsuarioModel;
import com.sofka.APIREST.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario") //En que direccion del servidor se va a activar los metodos de esta clase 
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService; //Se auto instancia

    //Cuando llegue una peticion GET, haga esta opcion (con los usuarios)
    @GetMapping() 
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    //RequestBody hace que puedan enviar datos del usuario en el cuerpo de la solicitud HTTP
    @PostMapping() 
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    //Buscar por ID del usuario
    @GetMapping( path = "/{id}") // Ejemplo: usuarios/1
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id); 
    }

    //Obtener un usuario por su prioridad
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad); 
    }

    //Eliminar un usuario por su ID
    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}