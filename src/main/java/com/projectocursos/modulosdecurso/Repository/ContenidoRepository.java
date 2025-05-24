package com.projectocursos.modulosdecurso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectocursos.modulosdecurso.model.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Integer>{
    
}
