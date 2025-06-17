package com.colegio.colegio.controller;

import com.colegio.colegio.dto.MateriaConAlumnosDTO;
import com.colegio.colegio.dto.MateriaDTO;
import com.colegio.colegio.service.interf.MateriaServiceInterface;
import jakarta.servlet.ServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    MateriaServiceInterface materiaServiceInterface;

    @GetMapping()
    public List<MateriaDTO> listarMaterias(){
        return materiaServiceInterface.listarMaterias();
    }

    @GetMapping("/{id}")
    public MateriaDTO traerMateria(@PathVariable Long id){
        return materiaServiceInterface.traerMateria(id);
    }

    @DeleteMapping("/{id}")
    public void borrarMateria(@PathVariable Long id){
        materiaServiceInterface.eliminarMateria(id);
    }

    @PostMapping
    public MateriaDTO guardarMateria(@Valid @RequestBody MateriaDTO materiaDto){
        return materiaServiceInterface.guardarMateria(materiaDto);
    }

    @PutMapping("/{id}")
    public MateriaDTO actualizarProfesor(@PathVariable Long id,
                                         @Valid @RequestBody MateriaDTO materiaDTO){
        return materiaServiceInterface.actualizarMateria(id, materiaDTO);
    }

    @GetMapping("/materiaConAlumnos/{id}")
    public MateriaConAlumnosDTO listarMateriaConAlumnos(@PathVariable Long id){
        return materiaServiceInterface.buscarMateriaConAlumnos(id);
    }
}
