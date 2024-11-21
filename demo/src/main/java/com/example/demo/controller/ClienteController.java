package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping("/listarClientes")
    public String listarClientes(Model model) {
        model.addAttribute("listarClientes", clienteService.listarClientes());
        return "clientes/listarClientes";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/nuevoCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.guardarCliente (cliente);
        return "redirect:/clientes/listarClientes";
    }

    @GetMapping("/actualizarCliente/{id}")
    public String actualizarCliente(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cliente", clienteService.obtenerClientePorId(id));
        return "clientes/actualizarCliente";
    }

    @GetMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes/listarClientes";
    }
}
