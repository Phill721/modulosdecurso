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

import com.projectocursos.modulosdecurso.Repository.ModuloRepository;
import com.projectocursos.modulosdecurso.Service.ModuloService;
import com.projectocursos.modulosdecurso.model.Modulo;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {
    private final ModuloService moduloService;
    @Autowired
    public ModuloController(ModuloService moduloService){
        this.moduloService = moduloService;
    }

    @PostMapping
    public ResponseEntity<Modulo> crearModulo(@RequestBody Modulo modulo){
        Modulo nuevoModulo = moduloService.crearModulo(modulo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoModulo);
    }
    @Autowired
    private ModuloRepository moduloRepository;

    @GetMapping
    public List<Modulo> listaModulos(){
        return moduloRepository.findAll();
    }
}
