package com.projectocursos.modulosdecurso.Service;

import java.util.Optional;

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

    public Optional<Evaluacion> buscarporID(int id){
        return evaluacionRepository.findById(id);
    }

    public Optional<Evaluacion> actualizarEvaluacion(int id, Evaluacion updatedEvaluacion){
        return evaluacionRepository.findById(id).map(evaluacion -> {
            evaluacion.setId(updatedEvaluacion.getId());
            evaluacion.setTitulo(updatedEvaluacion.getTitulo());
            evaluacion.setFechacreacion(updatedEvaluacion.getFechacreacion());
            evaluacion.setHorainicio(updatedEvaluacion.getHorainicio());
            evaluacion.setHoratermino(updatedEvaluacion.getHoratermino());
            evaluacion.setPuntajetotal(updatedEvaluacion.getPuntajetotal());
            evaluacion.setTipo(updatedEvaluacion.getTipo());
            evaluacion.setEstado(updatedEvaluacion.getEstado());
            evaluacion.setInstrucciones(updatedEvaluacion.getInstrucciones());
            evaluacion.setHabilidadesevaluadas(updatedEvaluacion.getHabilidadesevaluadas());
            evaluacion.setModulo(updatedEvaluacion.getModulo());
            return evaluacionRepository.save(evaluacion);
        });
    }
    public boolean eliminarEvaluacion(int id){
        if(evaluacionRepository.existsById(id)){
            evaluacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
