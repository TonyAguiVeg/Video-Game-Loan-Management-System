package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);

    }

    @Override
    public Usuario obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }


    @Override
    public void eliminarUsuario(Integer id) {
        if(usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("El usuario no existe" + id);
        }
    }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario, String password) {
        return usuarioRepository.findByNombreUsuarioAndPassword(nombreUsuario, password) ;
    }
}
