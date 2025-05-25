package com.projectocursos.modulosdecurso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectocursos.modulosdecurso.Repository.ModuloRepository;
import com.projectocursos.modulosdecurso.model.Modulo;

@Service
public class ModuloService {
    private final ModuloRepository moduloRepository;
    
    @Autowired
    public ModuloService(ModuloRepository moduloRepository){
        this.moduloRepository = moduloRepository;
    }
    public Modulo crearModulo(Modulo modulo){
        return moduloRepository.save(modulo);
    
    }
}
