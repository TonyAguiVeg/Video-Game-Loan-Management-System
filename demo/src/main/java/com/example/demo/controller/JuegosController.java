package com.example.demo.controller;

import com.example.demo.model.Juegos;
import com.example.demo.service.JuegoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/juegos")
@RequiredArgsConstructor
public class JuegosController {
    private final JuegoService juegoService;

    @GetMapping("/listarJuegos")
    public String paginaInicio(Model model) {
        model.addAttribute("juegos", juegoService.listarJuegos());
        return "juegos/listarJuegos";
    }

    @GetMapping("/nuevoJuego")
    public String nuevoJuego(Model model) {
        model.addAttribute("juego", new Juegos());
        return "juegos/nuevoJuego";
    }

    @PostMapping("/guardarJuego")
    public String guardarJuego(@ModelAttribute("juego") Juegos juego) {
        juegoService.guardarJuego(juego);
        return "redirect:/juegos/listarJuegos";
    }

    @GetMapping("/actualizarJuego/{id}")
    public String actualizarJuego(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("juego", juegoService.obtenerJuego(id));
        return "juegos/actualizarJuego";
    }

    @GetMapping("/eliminarJuego/{id}")
    public String eliminarJuego(@PathVariable("id") Integer id) {
        juegoService.eliminarJuego(id);
        return "redirect:/juegos/listarJuegos";
    }
}
