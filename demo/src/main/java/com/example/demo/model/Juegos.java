package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_juegos")
@Setter
@Getter
public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private Integer idJuego;
    @Column(name = "nom_juego", nullable = false, length = 70)
    private String nomJuego;
    @Column(name = "des_juego", nullable = false, length = 300)
    private String desJuego;
    @Column(name = "dispo_jueg", nullable = true, length = 20)
    private String dispoJueg;
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal Precio;

    @ManyToMany(mappedBy = "juegos")
    private List<Reserva> reserva = new ArrayList<>();

}