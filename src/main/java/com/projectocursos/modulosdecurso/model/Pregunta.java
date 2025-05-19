package com.projectocursos.modulosdecurso.model;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Pregunta {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String enunciado;
    private ArrayList<String> opciones;
    private int indicerespuesta;
    private int puntos;
    private String tipo;
    private String feedback;
}
