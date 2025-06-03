package com.projectocursos.modulosdecurso.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectocursos.modulosdecurso.Repository.CalificacionRepository;
import com.projectocursos.modulosdecurso.Repository.EstudianteRepository;
import com.projectocursos.modulosdecurso.Repository.EvaluacionRepository;
import com.projectocursos.modulosdecurso.model.Calificacion;
import com.projectocursos.modulosdecurso.model.Estudiante;
import com.projectocursos.modulosdecurso.model.Evaluacion;

@Service
public class CalificacionService {
    private final CalificacionRepository calificacionRepository;

    @Autowired
    public CalificacionService(CalificacionRepository calificacionRepository){
        this.calificacionRepository = calificacionRepository;
    }

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public Calificacion crearCalificacion(Calificacion calificacion){
        return calificacionRepository.save(calificacion);
    }

    public Optional<Calificacion> buscarxid(int id){
        return calificacionRepository.findById(id);
    }

    public Optional<Calificacion> actualizarCalificacion(int id, Calificacion updatedCalificacion){
        return calificacionRepository.findById(id).map(calificacion -> {
            calificacion.setValor(updatedCalificacion.getValor());
            calificacion.setEvaluacion(updatedCalificacion.getEvaluacion());
            calificacion.setEstudiante(updatedCalificacion.getEstudiante());
            return calificacionRepository.save(calificacion);
            
        });
    }
    public boolean eliminarCalificacion(int id){
        if (calificacionRepository.existsById(id)){
            calificacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public void Calificar(int estudiante, int evaluacion, double valor){
        Estudiante est = estudianteRepository.findById(estudiante)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Evaluacion ev = evaluacionRepository.findById(evaluacion)
            .orElseThrow(() -> new RuntimeException("Evaluacion no encontrado"));

        Calificacion cal = new Calificacion();
        cal.setEstudiante(est);
        cal.setEvaluacion(ev);
        cal.setValor(valor);
        calificacionRepository.save(cal);
       
    }
}
