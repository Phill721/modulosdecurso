package com.projectocursos.modulosdecurso.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectocursos.modulosdecurso.Repository.InstructorRepository;
import com.projectocursos.modulosdecurso.model.Instructor;





@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository){
        this.instructorRepository = instructorRepository;
    }

    public Instructor crearInstructor(Instructor instructor){
        return instructorRepository.save(instructor);
    }

    public Optional<Instructor> buscarxid(int id){
        return instructorRepository.findById(id);
    }

    public Optional<Instructor> actualizarInstructor(int id, Instructor updatedInstructor){
        return instructorRepository.findById(id).map(instructor -> {
            instructor.setId(updatedInstructor.getId());
            instructor.setCorreo(updatedInstructor.getCorreo());
            instructor.setPassword(updatedInstructor.getPassword());
            instructor.setUsuario(updatedInstructor.getUsuario());
            instructor.setNombrereal(updatedInstructor.getNombrereal());
            instructor.setEspecialidad(updatedInstructor.getEspecialidad());
            return instructorRepository.save(instructor);
        });
    }

    public boolean eliminarInstructor(int id){
        if(instructorRepository.existsById(id)){
            instructorRepository.deleteById(id);
            return true;
        } return false;
    }
}
