package com.projectocursos.modulosdecurso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectocursos.modulosdecurso.model.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
    
}
