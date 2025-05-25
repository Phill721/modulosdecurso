package com.projectocursos.modulosdecurso.Service;

import java.util.Optional;

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

    public Optional<Estudiante> buscarxid(int id){
        return estudianteRepository.findById(id);
    }

    public Optional<Estudiante> actualizarEstudiante(int id, Estudiante updatedEstudiante){
        return estudianteRepository.findById(id).map(estudiante -> {
            estudiante.setId(updatedEstudiante.getId());
            estudiante.setCorreo(updatedEstudiante.getCorreo());
            estudiante.setPassword(updatedEstudiante.getPassword());
            estudiante.setUsuario(updatedEstudiante.getUsuario());
            estudiante.setNombrereal(updatedEstudiante.getNombrereal());
            return estudianteRepository.save(estudiante);
        });
    }
    public boolean eliminarEstudiante(int id){
        if(estudianteRepository.existsById(id)){
            estudianteRepository.deleteById(id);
            return true;
        } return false;
    }
}
