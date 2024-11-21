package com.example.demo.service;

import com.example.demo.model.Entrega;

import java.util.Date;
import java.util.List;

public interface EntregaService {
    List<Entrega> listarEntregas();
    Entrega obtenerEntrega(Integer Id);
    Entrega guardarEntrega(Entrega entrega);
    List<Entrega> listarEntregaPorfecha(Date fechEntrega);

}
