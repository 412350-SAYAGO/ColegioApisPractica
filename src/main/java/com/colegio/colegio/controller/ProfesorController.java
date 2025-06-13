package com.colegio.colegio.controller;

import com.colegio.colegio.dto.ProfesorDTO;
import com.colegio.colegio.models.Profesor;
import com.colegio.colegio.service.impl.ProfesorServiceImpl;
import com.colegio.colegio.service.interf.ProfesorServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
    @Autowired
    ProfesorServiceInterface profesorService;

    @GetMapping
    public List<ProfesorDTO> obtenerProfesores(){
        return profesorService.obtenerProfesores();
    }

    @GetMapping("/{id}")
    public ProfesorDTO obtenerProfesorPorId(@PathVariable Long id){
        return profesorService.obtenerProfesorPorId(id);
    }

    @PostMapping
    public ProfesorDTO guardarProfesor(@Valid @RequestBody ProfesorDTO profesorDto){
        return profesorService.guardarProfesor(profesorDto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProfesor(@PathVariable Long id){
        profesorService.eliminarProfesor(id);
    }

    @PutMapping("/{id}")
    public ProfesorDTO actualizarProfesor(
            @Valid @RequestBody ProfesorDTO profesorDTO,
            @PathVariable Long id){
        return profesorService.actualizarProfesor(id, profesorDTO);
    }


}
