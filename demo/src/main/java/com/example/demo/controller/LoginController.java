package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
@Controller
@RequestMapping("/acceso")
@RequiredArgsConstructor
@SessionAttributes("usuario")

public class LoginController {
    @Autowired
    private final UsuarioService usuarioService;

    @GetMapping(value="/login")
    public String inicioLogin(){
        return "acceso/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("nombreUsuario") String nombreUsuario,
                        @RequestParam("password") String password,
                        Model model){

        Usuario usuario = usuarioService.obtenerUsuario(nombreUsuario, password);
        if(usuario==null){
            model.addAttribute("error", "nombreUsuario y/o password incorrectos");
            return "redirect:/acceso/login?error=true";
        }

        model.addAttribute("usuario", usuario);
        return "/acceso/index";
    }

    @RequestMapping("/index")
    public String mostrarInicio() {
        return "/acceso/index";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "redirect:/acceso/login?logout=true";
    }

}


