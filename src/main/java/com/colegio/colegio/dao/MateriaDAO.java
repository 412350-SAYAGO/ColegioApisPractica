package com.colegio.colegio.dao;


import com.colegio.colegio.models.Materia;
import com.colegio.colegio.repository.MateriaRepository;
import org.modelmapper.internal.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MateriaDAO {

    @Autowired
    private MateriaRepository materiaRepository;

    //esto es save o update
    public Materia save(Materia materia){
        return materiaRepository.save(materia);
    }

    public Optional<Materia> findById(Long id){
        return materiaRepository.findById(id);
    }

    public List<Materia> findAll(){
        return materiaRepository.findAll();
    }

    public void deleteById(Long id){
        materiaRepository.deleteById(id);
    }
}
