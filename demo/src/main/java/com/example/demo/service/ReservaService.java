package com.example.demo.service;

import com.example.demo.model.Reserva;

import java.util.Date;
import java.util.List;


public interface ReservaService  {
    List<Reserva> listarReservas();
    void guardarReserva(Reserva reserva);
    Reserva obtenerReservaPorId(Integer id);
    void eliminarReserva(Integer id);
    List<Reserva> listarReservaPorFecha(Date fechReserva);
}
