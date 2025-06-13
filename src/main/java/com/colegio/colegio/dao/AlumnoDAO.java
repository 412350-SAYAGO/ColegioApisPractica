package com.colegio.colegio.dao;

import com.colegio.colegio.models.Alumno;
import com.colegio.colegio.repository.AlumnoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public class AlumnoDAO {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> findAll(){
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> findById(Long id){
        return alumnoRepository.findById(id);
    }

    public Alumno save(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public void delete(Long id){
        alumnoRepository.deleteById(id);
    }

}
