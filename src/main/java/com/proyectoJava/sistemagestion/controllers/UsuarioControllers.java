package com.proyectoJava.sistemagestion.controllers;

import com.proyectoJava.sistemagestion.dao.UsuarioDao;
import com.proyectoJava.sistemagestion.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControllers {
    @Autowired
    private UsuarioDao usuarioDao;


    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {
      Usuario usuario = new Usuario();
      usuario.setId(id);
      usuario.setNombre("Gabriel");
      usuario.setApellido("baz");
      usuario.setEmail("GarielBaz91@gmail.com");
      usuario.setTelefono("454447444");

      return usuario;

    }
    @RequestMapping(value = "usuarios12")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("moy");
        usuario.setEmail("lucasmoy@gmail.com");
        usuario.setTelefono("454447444");

        return usuario;

    }
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
            usuarioDao.eliminar(id);

    }
    @RequestMapping(value = "usuarios123")
    public Usuario buscar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("moy");
        usuario.setEmail("lucasmoy@gmail.com");
        usuario.setTelefono("454447444");

        return usuario;

    }

    @RequestMapping(value = "/api/usuarios", method = RequestMethod.GET)

    public List<Usuario> getUsuario () {

     return usuarioDao.getUsuarios();

    }

    @RequestMapping(value = "/api/usuarios", method = RequestMethod.POST)

    public void registrarUsuario (@RequestBody Usuario usuario) {
        usuarioDao.registrar(usuario) ;
    }


}
