package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Data
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "name_usuario", nullable = false, length = 50, unique = true)
    private String nombreUsuario;

    @Column(name = "contrasena", nullable = false, length = 50)
    private String password;

    @OneToOne
    @JoinColumn(name = "id_cliente", unique = true)
    private Cliente cliente;
}
