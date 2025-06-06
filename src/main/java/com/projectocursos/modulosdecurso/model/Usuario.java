package com.projectocursos.modulosdecurso.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Usuario {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false, unique = true)
    private String correo;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false, unique = true)
    private String usuario;

    @Column(length = 50, nullable = true)
    private String nombrereal;
}
