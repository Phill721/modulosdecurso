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

import com.projectocursos.modulosdecurso.Repository.EstudianteRepository;
import com.projectocursos.modulosdecurso.Service.EstudianteService;
import com.projectocursos.modulosdecurso.model.Estudiante;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService){
        this.estudianteService = estudianteService;
    }
    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante){
        Estudiante newEstudiante = estudianteService.crearEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEstudiante);
    }
    @Autowired
    private EstudianteRepository estudianteRepository;
    @GetMapping
    public List<Estudiante> listarEstudiantes(){
        return estudianteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> buscarxid(@PathVariable int id){
        return estudianteService.buscarxid(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable int id, @RequestBody Estudiante nuevoEstudiante){
        return estudianteService.actualizarEstudiante(id, nuevoEstudiante)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable int id){
        if(estudianteService.eliminarEstudiante(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
