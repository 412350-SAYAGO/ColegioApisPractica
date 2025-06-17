package com.colegio.colegio.service.impl;

import com.colegio.colegio.dao.MateriaDAO;
import com.colegio.colegio.dao.ProfesorDAO;
import com.colegio.colegio.dto.AlumnoDTO;
import com.colegio.colegio.dto.MateriaConAlumnosDTO;
import com.colegio.colegio.dto.MateriaDTO;
import com.colegio.colegio.models.Alumno;
import com.colegio.colegio.models.Materia;
import com.colegio.colegio.models.Profesor;
import com.colegio.colegio.service.interf.MateriaServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImpl implements MateriaServiceInterface {

    @Autowired
    private MateriaDAO materiaDAO;


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ProfesorDAO profesorDAO;

    @Override
    public MateriaDTO guardarMateria(MateriaDTO materiaDTO) {
        Materia materia = new Materia();
        materia.setNombre(materiaDTO.getNombre());
        Profesor profesor = profesorDAO.obtenerProfesorPorId(materiaDTO.getProfesorId()).orElseThrow();
        materia.setProfesor(profesor);
        Materia nuevaMateria = materiaDAO.save(materia);
        return modelMapper.map(nuevaMateria, MateriaDTO.class);

    }

    @Override
    public List<MateriaDTO> listarMaterias() {
        List<Materia> listaMaterias = materiaDAO.findAll();
        List<MateriaDTO> materiasEncontradas = new ArrayList<>();
        for (Materia materia : listaMaterias){
            MateriaDTO materiaDTO = new MateriaDTO();
            materiaDTO.setId(materia.getId());
            materiaDTO.setNombre(materia.getNombre());
            materiaDTO.setProfesorId(materia.getProfesor().getId());
            materiasEncontradas.add(materiaDTO);
        }
        return materiasEncontradas;
    }

    @Override
    public MateriaDTO traerMateria(Long id) {
        Optional<Materia> materia = materiaDAO.findById(id);
        return modelMapper.map(materia, MateriaDTO.class);
    }

    @Override
    public MateriaDTO actualizarMateria(Long id, MateriaDTO materiaDTO) {
        Materia materia = materiaDAO.findById(id).orElseThrow();
        materia.setNombre(materiaDTO.getNombre());
        Profesor profesor = profesorDAO.obtenerProfesorPorId(materiaDTO.getProfesorId()).orElseThrow();
        materia.setProfesor(profesor);
        Materia materiaActualizada = materiaDAO.save(materia);

        return modelMapper.map(materiaActualizada, MateriaDTO.class);
    }

    @Override
    public void eliminarMateria(Long id) {
        materiaDAO.deleteById(id);
    }

    @Override
    public MateriaConAlumnosDTO buscarMateriaConAlumnos(Long id) {
        Materia materia = materiaDAO.findById(id).orElseThrow();

        MateriaConAlumnosDTO materiaConAlumnosDTO = new MateriaConAlumnosDTO();

        List<AlumnoDTO> listaAlumnos = new ArrayList<>();
        for(Alumno alumno : materia.getAlumnos()){
            listaAlumnos.add(modelMapper.map(alumno, AlumnoDTO.class));
        }

        materiaConAlumnosDTO.setListaAlumnos(listaAlumnos);
        materiaConAlumnosDTO.setProfesorId(materia.getProfesor().getId());
        materiaConAlumnosDTO.setNombre(materia.getNombre());
        materiaConAlumnosDTO.setId(materia.getId());

        return materiaConAlumnosDTO;

    }
}
