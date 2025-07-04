package com.colegio.colegio.dto;

import com.colegio.colegio.models.Alumno;
import lombok.Data;

import java.util.List;

@Data
public class MateriaConAlumnosDTO {

    private Long id;
    private String nombre;
    private Long profesorId;
    private List<AlumnoDTO> listaAlumnos;

}
