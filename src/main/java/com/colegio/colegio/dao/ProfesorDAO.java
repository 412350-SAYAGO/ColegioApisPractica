package com.colegio.colegio.dao;

import com.colegio.colegio.dto.ProfesorDTO;
import com.colegio.colegio.models.Profesor;
import com.colegio.colegio.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfesorDAO {
    @Autowired
    ProfesorRepository profesorRepository;

    public Optional<Profesor> obtenerProfesorPorId(Long id){
        return profesorRepository.findById(id);
    }

    public List<Profesor> obtenerProfesores(){
        return profesorRepository.findAll();
    }

    public Profesor guardarProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }

    public Profesor actualizarProfesor(Profesor profesor){

        return profesorRepository.save(profesor);
    }

    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }

}
