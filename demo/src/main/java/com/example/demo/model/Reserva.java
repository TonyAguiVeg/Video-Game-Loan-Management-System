package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="tb_reserva")
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @Column(name = "fech_reserva")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechReserva;

    @Column(name = "hora_reserva")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaReserva;

    @Column(name = "cantidad")
    private Integer Cantidad;

    @Column(name = "estado_reserva", length = 50)
    private String estadoReserva;

    @OneToOne(mappedBy = "reserva")
    private Entrega entrega;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToMany()
    @JoinTable(
            name = "tb_res_vjuegos",
            joinColumns  =@JoinColumn(name = "id_reserva"),
            inverseJoinColumns = @JoinColumn(name = "id_juego")
    )
    private Set<Juegos> juegos;




}
