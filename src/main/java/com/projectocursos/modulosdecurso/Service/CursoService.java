package com.projectocursos.modulosdecurso.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectocursos.modulosdecurso.Repository.CursoRepository;
import com.projectocursos.modulosdecurso.model.Curso;



@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    public Curso crearCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public Optional<Curso> buscarxid(int id){
        return cursoRepository.findById(id);
    }

    public Optional<Curso> actualizarCurso(int id, Curso updatedCurso){
        return cursoRepository.findById(id).map(curso -> {
            curso.setId(updatedCurso.getId());
            curso.setTitulo(updatedCurso.getTitulo());
            curso.setDescripcion(updatedCurso.getDescripcion());
            curso.setCategoria(updatedCurso.getCategoria());
            curso.setNivel(updatedCurso.getNivel());
            curso.setPrecio(updatedCurso.getPrecio());
            curso.setSeccion(updatedCurso.getSeccion());
            curso.setEstado(updatedCurso.getEstado());
            curso.setCupo(updatedCurso.getCupo());
            curso.setCupones(updatedCurso.getCupones());
            return cursoRepository.save(curso);
        });
    }

    public boolean eliminarxid(int id){
        if(cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
