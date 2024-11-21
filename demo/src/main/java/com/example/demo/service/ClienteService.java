package com.example.demo.service;

import com.example.demo.model.Cliente;

import java.util.List;

public interface ClienteService
{
    List<Cliente> listarClientes();
    void guardarCliente(Cliente cliente);
    Cliente obtenerClientePorId(Integer id);
    void eliminarCliente(Integer id);

}
