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

import com.projectocursos.modulosdecurso.Repository.CalificacionRepository;
import com.projectocursos.modulosdecurso.Service.CalificacionService;
import com.projectocursos.modulosdecurso.model.Calificacion;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {
    private final CalificacionService calificacionService;

    @Autowired
    public CalificacionController(CalificacionService calificacionService){
        this.calificacionService = calificacionService;
    }
    @PostMapping
    public ResponseEntity<Calificacion> crearCalificacion(@RequestBody Calificacion calificacion){
        Calificacion newCalificacion = calificacionService.crearCalificacion(calificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCalificacion);
    }
    @Autowired
    private CalificacionRepository calificacionRepository;
    @GetMapping
    public List<Calificacion> listarCalificaciones(){
        return calificacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> buscarxid(@PathVariable int id){
        return calificacionService.buscarxid(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable int id, @RequestBody Calificacion nuevaCalificacion){
        return calificacionService.actualizarCalificacion(id, nuevaCalificacion)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCalificacion(@PathVariable int id){
        if (calificacionService.eliminarCalificacion(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/calificar/{Estudianteid}/{Evaluacionid}/{valor}")
    public ResponseEntity<String> calificar( @PathVariable int Estudianteid,
        @PathVariable int Evaluacionid,
        @PathVariable double valor){
            calificacionService.Calificar(Estudianteid, Evaluacionid, valor);;
            return ResponseEntity.ok("Estudiante calificado");
        }

}
