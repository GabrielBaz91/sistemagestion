package com.proyectoJava.sistemagestion.dao;

import com.proyectoJava.sistemagestion.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();


    void eliminar(Long id);

    void registrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);

    default boolean verificarEmailPassword(Usuario usuario) {
        return false;
    }
}
