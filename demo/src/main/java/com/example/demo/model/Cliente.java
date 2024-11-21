package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="tb_cliente")
@Data
@Setter
@Getter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "nom_cliente", nullable = false, length = 50)
    private String nomCliente;
    @Column(name = "ap_pat", length = 50, nullable = false)
    private String apPat;
    @Column(name = "ap_mat", length = 50, nullable = false)
    private String apMat;
    @Column(name = "dni", length = 8, nullable = false)
    private String Dni;
    @Column(name = "tel", length = 10, nullable = false)
    private String telef;
    @Column(name = "correo", length = 50, nullable = false)
    private String Correo;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private Set<Reserva> reserva;
}
