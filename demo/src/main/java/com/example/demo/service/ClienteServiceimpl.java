package com.example.demo.service;


import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceimpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    @Override
    public List<Cliente> listarClientes() {
        return  clienteRepository.findAll();
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);

    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id).
                orElseThrow(()-> new RuntimeException("No se encontro el cliente con id: " + id));
    }

    @Override
    public void eliminarCliente(Integer id) {
        if(clienteRepository.existsById(id)) {
                clienteRepository.deleteById(id);
        }else { throw new RuntimeException("No se encontro a este cliente"); }
    }

}
