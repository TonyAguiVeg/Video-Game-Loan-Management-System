package com.example.demo.service;


import com.example.demo.model.Juegos;
import com.example.demo.repository.JuegosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JuegosServiceImpl implements JuegoService {
    private final JuegosRepository juegosRepository;

    @Override
    public List<Juegos> listarJuegos() {
        return juegosRepository.findAll();
    }

    @Override
    public void guardarJuego(Juegos juego) {
        juegosRepository.save(juego);
    }

    @Override
    public Juegos obtenerJuego(Integer id) {
        return juegosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el juego con id: " + id));
    }

    @Override
    public void eliminarJuego(Integer id) {
        if (juegosRepository.existsById(id)) {
            juegosRepository.deleteById(id);
        } else {
            throw new RuntimeException("Juego no encontrado con el id: " + id);
        }
    }




}
