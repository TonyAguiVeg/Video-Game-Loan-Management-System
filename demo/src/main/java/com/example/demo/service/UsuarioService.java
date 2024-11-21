package com.example.demo.service;

import com.example.demo.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listarUsuarios();
    void guardarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Integer id);
    void eliminarUsuario(Integer id);

    Usuario obtenerUsuario(String nombreUsuario,String password);
}
