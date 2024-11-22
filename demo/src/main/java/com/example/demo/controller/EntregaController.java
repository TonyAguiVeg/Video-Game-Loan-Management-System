package com.example.demo.controller;

import com.example.demo.model.Entrega;
import com.example.demo.service.EntregaService;
import com.example.demo.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/entregas")
@RequiredArgsConstructor
public class EntregaController {

    private final EntregaService entregaService;
    private final ReservaService reservaService;

    @GetMapping("/listarEntregas")
    public String verPaginaInicio(Model model) {
        model.addAttribute("listarEntregas", entregaService.listarEntregas());
        return "entregas/listarEntregas";
    }

    @GetMapping("/nuevaEntrega")
    public String nuevaEntrega(Model model) {
        Entrega entrega = new Entrega();
        model.addAttribute("entrega", entrega);
        model.addAttribute("reservas", reservaService.listarReservas());
        return "entregas/nuevaEntrega";
    }

    @PostMapping("/guardarEntrega")
    public String guardarEntrega(@ModelAttribute("entrega") Entrega entrega) {
        entregaService.guardarEntrega(entrega);

        return "redirect:/entregas/listarEntregas";
    }

    @GetMapping("/actualizarEntrega/{id}")
    public String actualizarEntrega(@PathVariable(value = "id") Integer id, Model model) {
        Entrega entrega = entregaService.obtenerEntrega(id);

        model.addAttribute("entrega", entrega);
        model.addAttribute("reserva", reservaService.listarReservas());
        return "entregas/actualizarEntrega";
    }

    @GetMapping("/inicioBusqueda")
    public String verPaginaInicioBusqueda() {
        return "entregas/verPaginaInicioBusqueda";
    }

    @GetMapping("/busquedaEntrega")
    public String busquedaEntrega(Model model,
                                  @RequestParam(value = "fechEntrega", required = false)
                                  @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechEntrega) {
        List<Entrega> lista = (fechEntrega != null)
                ? entregaService.listarEntregaPorfecha(fechEntrega)
                : entregaService.listarEntregas();
        model.addAttribute("listaEntregas", lista);
        model.addAttribute("fechEntrega", fechEntrega != null ? fechEntrega : new Date());
        return "entregas/busquedaEntrega";
    }

    @GetMapping("/detalles/{id}")
    @ResponseBody
    public Map<String, Object> obtenerDetallesEntrega(@PathVariable Integer id) {
        Entrega entrega = entregaService.obtenerEntrega(id);
        if (entrega == null) {
            throw new RuntimeException("Entrega no encontrada");
        }


        Map<String, Object> detalles = new HashMap<>();
        detalles.put("clienteNombre", entrega.getReserva().getCliente().getNomCliente() + " " +
                entrega.getReserva().getCliente().getApPat() + " " +
                entrega.getReserva().getCliente().getApMat());
        detalles.put("clienteCorreo", entrega.getReserva().getCliente().getCorreo());
        detalles.put("clienteTelefono", entrega.getReserva().getCliente().getTelef());
        detalles.put("videojuegos", entrega.getReserva().getJuegos()
                .stream().map(juego -> juego.getNomJuego()).collect(Collectors.toList()));

        return detalles;
    }

}
