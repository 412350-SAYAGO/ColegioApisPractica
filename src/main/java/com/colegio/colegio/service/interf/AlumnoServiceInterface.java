package com.colegio.colegio.service.interf;


import com.colegio.colegio.dao.AlumnoDAO;
import com.colegio.colegio.dto.AlumnoDTO;
import com.colegio.colegio.models.Alumno;

import java.util.List;

public interface AlumnoServiceInterface {

    List<AlumnoDTO> obtenerAlumnos();
    AlumnoDTO obtenerAlumnoPorId(Long id);
    AlumnoDTO guardarAlumno(AlumnoDTO alumnoDTO);
    void elimnarAlumno(Long id);
    AlumnoDTO actualizarAlumno(Long id, AlumnoDTO alumnoDTO);

}
