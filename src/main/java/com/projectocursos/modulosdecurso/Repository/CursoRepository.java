package com.projectocursos.modulosdecurso.Repository;

import org.springframework.stereotype.Repository;

import com.projectocursos.modulosdecurso.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
    
}
