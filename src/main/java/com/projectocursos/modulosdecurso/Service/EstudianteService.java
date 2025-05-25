package com.projectocursos.modulosdecurso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectocursos.modulosdecurso.Repository.EstudianteRepository;
import com.projectocursos.modulosdecurso.model.Estudiante;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;
    }
    public Estudiante crearEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }
}
