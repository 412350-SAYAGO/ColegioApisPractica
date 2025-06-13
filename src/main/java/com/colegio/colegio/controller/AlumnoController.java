package com.colegio.colegio.controller;

import com.colegio.colegio.dao.AlumnoDAO;
import com.colegio.colegio.dto.AlumnoDTO;
import com.colegio.colegio.service.interf.AlumnoServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoServiceInterface alumnoServiceInterface;
    @Autowired
    private InternalResourceViewResolver internalResourceViewResolver;

    @GetMapping
    public List<AlumnoDTO> obtenerAlumnos(){
        return alumnoServiceInterface.obtenerAlumnos();
    }

    @GetMapping("/{id}")
    public AlumnoDTO obtenerAlumnos(@PathVariable Long id){
        return alumnoServiceInterface.obtenerAlumnoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Long id){
         alumnoServiceInterface.elimnarAlumno(id);
    }

    @PostMapping
    public AlumnoDTO guardarAlumno(
            @Valid @RequestBody AlumnoDTO alumnoDTO
    ){
       return alumnoServiceInterface.guardarAlumno(alumnoDTO);
    }

    @PutMapping("/{id}")
    public AlumnoDTO actualizarAlumno(@Valid
                                      @RequestBody AlumnoDTO alumnoDTO,
                                      @PathVariable long id){
        return alumnoServiceInterface.actualizarAlumno(id, alumnoDTO);
    }

}
