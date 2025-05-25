package com.projectocursos.modulosdecurso.Service;

import java.util.Optional;

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
}
