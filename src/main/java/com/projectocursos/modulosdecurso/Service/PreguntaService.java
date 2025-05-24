package com.projectocursos.modulosdecurso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectocursos.modulosdecurso.Repository.PreguntaRepository;
import com.projectocursos.modulosdecurso.model.Pregunta;

@Service
public class PreguntaService {
    
    private final PreguntaRepository preguntaRepository;

    @Autowired
    public PreguntaService(PreguntaRepository preguntaRepository){
        this.preguntaRepository = preguntaRepository;
    }
    public Pregunta crearPregunta(Pregunta pregunta){
        return preguntaRepository.save(pregunta);
    }
}
