package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.ClienteService;
import com.example.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor

public class UsuarioController {
    private final UsuarioService usuarioService;
    private final ClienteService clienteService;

    @GetMapping("/listarUsuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("listarUsuarios", usuarioService.listarUsuarios());
        return "usuarios/listarUsuarios";
    }
    @GetMapping("/nuevoUsuario")
    public String nuevoUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        model.addAttribute("cliente", clienteService.listarClientes());
        return "usuarios/nuevoUsuario";
    }
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute ("usuario") Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios/listarUsuarios";
    }

    @GetMapping("/actualizarUsuario/{id}")
    public String actualizarUsuario(@PathVariable ("id") Integer id,Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("cliente", clienteService.listarClientes());
        return "usuarios/actualizarUsuario";
    }
    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable ("id") Integer id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios/listarUsuarios";
    }
}
