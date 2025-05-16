package com.projectocursos.modulosdecurso.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Evaluacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluacion {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String titulo;

    @Column(nullable = false)
    private LocalDate fechacreacion;

    @Column(nullable = false)
    private LocalDateTime horainicio;

    @Column(nullable = true)
    private LocalDateTime horatermino;

    @Column(nullable = false)
    private int duracionmin;

    @Column(nullable = false)
    private double puntajetotal;

    @Column(length = 50, nullable = false)
    private String tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEvaluacion estado;
    private ArrayList<Double> calificaciones;
    private String instrucciones;
    private ArrayList<String> habilidadesevaluadas;
}
