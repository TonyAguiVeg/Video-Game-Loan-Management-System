package com.example.demo.service;

import com.example.demo.model.Entrega;
import com.example.demo.repository.EntregaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EntregaServiceImpl implements EntregaService  {
    private final EntregaRepository entregaRepository;

    @Override
    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    @Override
    public Entrega obtenerEntrega(Integer Id) {
        return entregaRepository.findById(Id).
                orElseThrow(()-> new RuntimeException("No se ha encontrado devolucion realizada"));
    }

    @Override
    public Entrega guardarEntrega(Entrega entrega) {
        return  entregaRepository.save(entrega);
    }

    @Override
    public List<Entrega> listarEntregaPorfecha(Date fechEntrega) {
        return entregaRepository.listarEntregaPorfecha(fechEntrega);
    }


}
