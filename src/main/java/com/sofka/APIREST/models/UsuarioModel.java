package com.sofka.APIREST.models;

import javax.persistence.*;

@Entity //Especifica que es un modelo (Entidades de las Tablas de la BD)
@Table(name = "usuario") //Especificamos el nombre de la Tabla
public class UsuarioModel { //Nos permite definir el modelo de la BD

    @Id //Especificar que es una id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Que se genera automaticamente y que es autoincrement
    @Column(unique = true, nullable = false) //Identifica que es unico y no puede ser nulo
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;


    //Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPrioridad(){
        return prioridad;
    }

  
    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPrioridad(Integer prioridad){
        this.prioridad = prioridad;
    }
}