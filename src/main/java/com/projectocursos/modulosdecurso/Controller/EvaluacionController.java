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

import com.projectocursos.modulosdecurso.Repository.EvaluacionRepository;
import com.projectocursos.modulosdecurso.Service.EvaluacionService;
import com.projectocursos.modulosdecurso.model.Evaluacion;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {
    private final EvaluacionService evaluacionService;

    @Autowired
    public EvaluacionController(EvaluacionService evaluacionService){
        this.evaluacionService = evaluacionService;
    }
    @PostMapping
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion){
        Evaluacion newEvaluacion = evaluacionService.crearEvaluacion(evaluacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEvaluacion);
    }
    @Autowired
    private EvaluacionRepository evaluacionRepository;
    @GetMapping
    public List<Evaluacion> listarEvaluaciones(){
        return evaluacionRepository.findAll();
    }
}
