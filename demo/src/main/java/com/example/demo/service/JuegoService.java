package com.example.demo.service;


import com.example.demo.model.Juegos;

import java.util.List;

public interface JuegoService {
    List<Juegos> listarJuegos();
    void guardarJuego(Juegos juego);
    Juegos obtenerJuego(Integer id);
    void eliminarJuego(Integer id);


}
