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

import com.projectocursos.modulosdecurso.Repository.CursoRepository;
import com.projectocursos.modulosdecurso.Service.CursoService;
import com.projectocursos.modulosdecurso.model.Curso;



@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso){
        Curso newCurso = cursoService.crearCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCurso);
    }

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> listar(){
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarxid(@PathVariable int id){
        return cursoService.buscarxid(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable int id, @RequestBody Curso nuevoCurso){
        return cursoService.actualizarCurso(id, nuevoCurso)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable int id){
        if(cursoService.eliminarxid(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{curso_id}/inscribir/{estudiante_id}")
    public ResponseEntity<String> inscribirEstudiante(@PathVariable int curso_id, @PathVariable int estudiante_id){
        cursoService.inscribirEstudiante(curso_id, estudiante_id);
        return ResponseEntity.ok("Estudiante inscrito con exito");
    }

    @PostMapping("/{curso_id}/asignar/{instructor_id}")
    public ResponseEntity<String> asignarInstructor(
        @PathVariable int curso_id,
        @PathVariable int instructor_id
    ){
        cursoService.asignarInstructor(curso_id, instructor_id);
        return ResponseEntity.ok("Instructor asignado correctamente");
    }
}
