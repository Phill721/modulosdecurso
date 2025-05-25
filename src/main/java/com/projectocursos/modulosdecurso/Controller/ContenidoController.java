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

import com.projectocursos.modulosdecurso.Repository.ContenidoRepository;
import com.projectocursos.modulosdecurso.Service.ContenidoService;
import com.projectocursos.modulosdecurso.model.Contenido;

@RestController
@RequestMapping("/api/contenido")
public class ContenidoController {
    private final ContenidoService contenidoService;

    @Autowired
    public ContenidoController(ContenidoService contenidoService){
        this.contenidoService = contenidoService;
    }
    @PostMapping
    public ResponseEntity<Contenido> crearContenido(@RequestBody Contenido contenido){
        Contenido newContenido = contenidoService.crearContenido(contenido);
        return ResponseEntity.status(HttpStatus.CREATED).body(newContenido);
    }
    @Autowired
    private ContenidoRepository contenidoRepository;
    @GetMapping
    public List<Contenido> listarContenido(){
        return contenidoRepository.findAll();
    }
}
