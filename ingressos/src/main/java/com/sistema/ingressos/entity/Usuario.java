package com.sistema.ingressos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, length = 150)
    private String nomeUsuario;

    @Column(nullable = false, unique = true)
    private String email;

    private String telefone; 
}