package com.example.demo.service;

import com.example.demo.model.Reserva;
import com.example.demo.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public void guardarReserva(Reserva reserva) {
        reservaRepository.save(reserva);

    }

    @Override
    public Reserva obtenerReservaPorId(Integer id) {
        return reservaRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Reserva no encontrada" + id));
    }

    @Override
    public void eliminarReserva(Integer id) {
        if(reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Reserva no encontrada" + id);
        }
    }

    @Override
    public List<Reserva> listarReservaPorFecha(Date fechReserva) {
        return reservaRepository.listarReservaPorfecha(fechReserva);
    }
}
