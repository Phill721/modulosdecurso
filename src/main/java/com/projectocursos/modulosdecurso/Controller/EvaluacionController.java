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
    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> buscarporID(@PathVariable int id){
        return evaluacionService.buscarporID(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> actualizarEvaluacion(@PathVariable int id, @RequestBody Evaluacion nuevaEvaluacion){
        return evaluacionService.actualizarEvaluacion(id, nuevaEvaluacion)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable int id){
        if(evaluacionService.eliminarEvaluacion(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
