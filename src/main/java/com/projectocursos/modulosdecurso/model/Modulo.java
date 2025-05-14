package com.projectocursos.modulosdecurso.model;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Modulo")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para generar el id
    private int id;
    @Column(length = 30, nullable = false, unique = true)
    private String titulo;
    @Column(nullable = false)
    private int duracionsemanas;
    @Column(nullable = false)
    private int orden;
    @ElementCollection
    @CollectionTable(name = "modulo_recursos", joinColumns = @JoinColumn(name = "modulo_id"))
    @Column(name = "recursos")
    private ArrayList<String> recursos;
    @Column(nullable = false)
    private boolean esvisible;
    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "evaluacion_id", referencedColumnName = "id")
    private Evaluacion evaluacion;
}
