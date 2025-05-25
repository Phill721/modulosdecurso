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

import com.projectocursos.modulosdecurso.Repository.PreguntaRepository;
import com.projectocursos.modulosdecurso.Service.PreguntaService;
import com.projectocursos.modulosdecurso.model.Pregunta;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {
    
    private final PreguntaService preguntaService;

    @Autowired
    public PreguntaController(PreguntaService preguntaService){
        this.preguntaService = preguntaService;
    }

    @PostMapping
    public ResponseEntity<Pregunta> crearPregunta(@RequestBody Pregunta pregunta){
        Pregunta nuevPregunta = preguntaService.crearPregunta(pregunta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevPregunta);
    }
    @Autowired
    private PreguntaRepository preguntaRepository;

    @GetMapping
    public List<Pregunta> listaPreguntas(){
        return preguntaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> buscarxid(@PathVariable int id){
        return preguntaService.buscarxid(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pregunta> actualizarPregunta(@PathVariable int id, @RequestBody Pregunta nuevaPregunta){
        return preguntaService.actualizarPregunta(id, nuevaPregunta)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPregunta(@PathVariable int id){
        if (preguntaService.eliminarPregunta(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
