package com.projectocursos.modulosdecurso.model;



import jakarta.persistence.Column;
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
@Table(name = "calificacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calificacion {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double valor;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id", nullable = false)
    
    private Evaluacion evaluacion;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    
    private Estudiante estudiante;
}
