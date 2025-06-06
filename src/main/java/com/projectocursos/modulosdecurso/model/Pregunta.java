package com.projectocursos.modulosdecurso.model;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pregunta")

public class Pregunta {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200, nullable = false)
    private String enunciado;

    @ElementCollection
    private List<String> opciones = new ArrayList<>();

    @Column(nullable = false)
    private int indicerespuestacorrecta;

    @Column(nullable = false)
    private int puntos;
    
    @Column(length = 500, nullable = false)
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id")
    private Evaluacion evaluacion;

    public boolean esCorrecta(int respuesta){
        return this.indicerespuestacorrecta == respuesta;
    }
}
