package com.projectocursos.modulosdecurso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectocursos.modulosdecurso.Repository.InstructorRepository;
import com.projectocursos.modulosdecurso.Service.InstructorService;
import com.projectocursos.modulosdecurso.model.Instructor;

@RestController
@RequestMapping("/api/instructores")
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }
    
    @PostMapping
    public ResponseEntity<Instructor> crearInstructor(@RequestBody Instructor instructor){
        Instructor newInstructor = instructorService.crearInstructor(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newInstructor);
    }
    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping
    public List<Instructor> listarInstructores(){
        return instructorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> buscarxid(@PathVariable int id){
        return instructorService.buscarxid(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> actualizarInstructor(@PathVariable int id, @RequestBody Instructor nuevoInstructor){
        return instructorService.actualizarInstructor(id, nuevoInstructor)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInstructor(@PathVariable int id){
        if(instructorService.eliminarInstructor(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
