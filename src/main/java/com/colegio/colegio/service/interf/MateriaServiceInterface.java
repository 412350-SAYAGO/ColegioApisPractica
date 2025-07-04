package com.colegio.colegio.service.interf;

import com.colegio.colegio.dao.MateriaDAO;
import com.colegio.colegio.dto.MateriaConAlumnosDTO;
import com.colegio.colegio.dto.MateriaDTO;
import com.colegio.colegio.models.Materia;

import java.util.List;
import java.util.Optional;

public interface MateriaServiceInterface {

    MateriaDTO guardarMateria(MateriaDTO materiaDTO);

    List<MateriaDTO> listarMaterias();

    MateriaDTO traerMateria(Long id);

    MateriaDTO actualizarMateria(Long id, MateriaDTO materiaDTO);

    void eliminarMateria(Long id);

    MateriaConAlumnosDTO buscarMateriaConAlumnos(Long id);

}
