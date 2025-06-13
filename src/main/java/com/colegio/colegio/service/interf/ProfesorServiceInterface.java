package com.colegio.colegio.service.interf;

import com.colegio.colegio.dto.ProfesorDTO;
import com.colegio.colegio.models.Profesor;

import java.util.List;

public interface ProfesorServiceInterface {
    ProfesorDTO guardarProfesor(ProfesorDTO profesorDTO);

    void eliminarProfesor(Long id);

    List<ProfesorDTO> obtenerProfesores();

    ProfesorDTO obtenerProfesorPorId(Long id);

    ProfesorDTO actualizarProfesor(Long id, ProfesorDTO profesorDto);
}
