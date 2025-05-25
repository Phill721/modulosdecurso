package com.projectocursos.modulosdecurso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectocursos.modulosdecurso.Repository.EvaluacionRepository;
import com.projectocursos.modulosdecurso.model.Evaluacion;

@Service
public class EvaluacionService {
    private final EvaluacionRepository evaluacionRepository;

    @Autowired
    public EvaluacionService(EvaluacionRepository evaluacionRepository){
        this.evaluacionRepository = evaluacionRepository;
    }
    public Evaluacion crearEvaluacion(Evaluacion evaluacion){
        return evaluacionRepository.save(evaluacion);
    }
}
