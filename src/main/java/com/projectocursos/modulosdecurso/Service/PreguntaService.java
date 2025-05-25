package com.projectocursos.modulosdecurso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectocursos.modulosdecurso.Repository.PreguntaRepository;
import com.projectocursos.modulosdecurso.model.Pregunta;
import java.util.Optional;

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

    public Optional<Pregunta> buscarxid(int id){
        return preguntaRepository.findById(id);
    }

    public boolean validarRespuesta(int preguntaid, int respuesta){
        return preguntaRepository.findById(preguntaid)
            .map(pregunta -> pregunta.esCorrecta(respuesta))
            .orElse(false);
    }

    public Optional<Pregunta> actualizarPregunta(int id, Pregunta updatedPregunta){
        return preguntaRepository.findById(id).map(pregunta -> {
            pregunta.setId(updatedPregunta.getId());
            pregunta.setEnunciado(updatedPregunta.getEnunciado());
            pregunta.setOpciones(updatedPregunta.getOpciones());
            pregunta.setIndicerespuestacorrecta(updatedPregunta.getIndicerespuestacorrecta());
            pregunta.setPuntos(updatedPregunta.getPuntos());
            pregunta.setFeedback(updatedPregunta.getFeedback());
            pregunta.setEvaluacion(updatedPregunta.getEvaluacion());
            return preguntaRepository.save(pregunta);
        });
    }
    public boolean eliminarPregunta(int id){
        if(preguntaRepository.existsById(id)){
            preguntaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
