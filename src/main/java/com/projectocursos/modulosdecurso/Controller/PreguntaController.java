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
}
