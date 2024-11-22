package com.example.demo.controller;


import com.example.demo.model.Entrega;
import com.example.demo.model.Reserva;
import com.example.demo.service.ClienteService;
import com.example.demo.service.JuegoService;
import com.example.demo.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/reservas")
@RequiredArgsConstructor

public class ReservaController {

    private final ReservaService reservaService;
    private final ClienteService clienteService;
    private final JuegoService juegoService;


    @GetMapping("/listarReservas")
    public String listarReservas(Model model) {
        model.addAttribute("listarReservas", reservaService.listarReservas());
        return "reservas/listarReservas";
    }

    @GetMapping("/nuevaReserva")
    public String nuevaReserva(Model model) {
        Reserva reserva = new Reserva();
        model.addAttribute("reserva", reserva);
        model.addAttribute("cliente",clienteService.listarClientes());
        model.addAttribute("juego",juegoService.listarJuegos());
        return "reservas/nuevaReserva";
    }
    @PostMapping("/guardarReserva")
    public String guardarReserva(@ModelAttribute ("reserva") Reserva reserva) {
        reservaService.guardarReserva(reserva);
        return "redirect:/reservas/listarReservas";
    }
    @GetMapping("/actualizarReserva/{id}")
    public String actualizarReserva(@PathVariable("id") Integer id,Model model) {
        Reserva reserva = reservaService.obtenerReservaPorId(id);
        model.addAttribute("reserva", reserva);
        model.addAttribute("cliente",clienteService.listarClientes());
        model.addAttribute("juego",juegoService.listarJuegos());
        return "reservas/actualizarReserva";
    }

    @GetMapping("/eliminarReserva/{id}")
    public String eliminarReserva(@PathVariable("id") Integer id) {
        reservaService.eliminarReserva(id);
        return "redirect:/reservas/listarReservas";
    }


    @GetMapping("/inicioBusqueda")
    public String verPaginaInicioBusqueda() {
        return "reservas/verPaginaInicioBusqueda";
    }

    @GetMapping("/busquedaReserva")
    public String busquedaReserva(Model model,
                                  @RequestParam(value = "fechReserva", required = false)
                                  @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechReserva) {
        List<Reserva> lista = (fechReserva != null)
                ? reservaService.listarReservaPorFecha(fechReserva)
                : reservaService.listarReservas();
        model.addAttribute("listarReservas", lista);
        model.addAttribute("fechReserva", fechReserva != null ? fechReserva : new Date());
        return "reservas/busquedaReserva";
    }

    @GetMapping("/detalles/{id}")
    @ResponseBody
    public Map<String, Object> obtenerDetallesReserva(@PathVariable Integer id) {
        Reserva reserva = reservaService.obtenerReservaPorId(id);
        if (reserva == null) {
            throw new RuntimeException("reserva no encontrada");
        }


        Map<String, Object> detalles = new HashMap<>();
        detalles.put("clienteNombre", reserva.getCliente().getNomCliente() + " " +
                reserva.getCliente().getApPat() + " " +
                reserva.getCliente().getApMat());
        detalles.put("clienteCorreo", reserva.getCliente().getCorreo());
        detalles.put("clienteTelefono", reserva.getCliente().getTelef());
        detalles.put("videojuegos", reserva.getJuegos()
                .stream().map(juego -> juego.getNomJuego()).collect(Collectors.toList()));

        return detalles;
    }

}
