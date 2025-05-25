package com.projectocursos.modulosdecurso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
