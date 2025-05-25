package com.projectocursos.modulosdecurso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectocursos.modulosdecurso.Repository.ContenidoRepository;
import com.projectocursos.modulosdecurso.model.Contenido;

@Service
public class ContenidoService {
    private final ContenidoRepository contenidoRepository;

    @Autowired
    public ContenidoService(ContenidoRepository contenidoRepository){
        this.contenidoRepository = contenidoRepository;
    }
    public Contenido crearContenido(Contenido contenido){
        return contenidoRepository.save(contenido);
    }
    
}
