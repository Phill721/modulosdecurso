package com.projectocursos.modulosdecurso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectocursos.modulosdecurso.Repository.CalificacionRepository;
import com.projectocursos.modulosdecurso.model.Calificacion;

@Service
public class CalificacionService {
    private final CalificacionRepository calificacionRepository;

    @Autowired
    public CalificacionService(CalificacionRepository calificacionRepository){
        this.calificacionRepository = calificacionRepository;
    }

    public Calificacion crearCalificacion(Calificacion calificacion){
        return calificacionRepository.save(calificacion);
    }
}
