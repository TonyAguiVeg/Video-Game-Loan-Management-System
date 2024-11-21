package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;
import java.sql.Time;

@Entity
@Table(name="tb_entrega")
@Getter
@Setter
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Integer idEntrega;

    @Column(name = "fech_entrega")
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechEntrega;

    @Column(name = "hora_entrega")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaEntrega;

    @Column(name = "estado_entrega", length = 20)
    private String estadoEntrega;


    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;


}
