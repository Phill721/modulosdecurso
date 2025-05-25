package com.projectocursos.modulosdecurso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectocursos.modulosdecurso.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{
    
}
