package com.colegio.colegio.service.impl;

import com.colegio.colegio.dao.AlumnoDAO;
import com.colegio.colegio.dto.AlumnoDTO;
import com.colegio.colegio.models.Alumno;
import com.colegio.colegio.repository.AlumnoRepository;
import com.colegio.colegio.service.interf.AlumnoServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoServiceInterface {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AlumnoDAO alumnoDAO;



    @Override
    public List<AlumnoDTO> obtenerAlumnos() {
        List<Alumno> alumnosEncontrados = alumnoDAO.findAll();
        List<AlumnoDTO> alumnosMapeados = new ArrayList<>();
        for (Alumno alumno: alumnosEncontrados){
            alumnosMapeados.add(modelMapper.map(alumno, AlumnoDTO.class));
        }
        return alumnosMapeados;
    }

    @Override
    public AlumnoDTO obtenerAlumnoPorId(Long id) {
        Alumno alumnoEncontrado = alumnoDAO.findById(id).orElseThrow();
        return modelMapper.map(alumnoEncontrado, AlumnoDTO.class);
    }

    @Override
    public AlumnoDTO guardarAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumnoNuevo = modelMapper.map(alumnoDTO, Alumno.class);
        return modelMapper.map(alumnoDAO.save(alumnoNuevo), AlumnoDTO.class);
    }

    @Override
    public void elimnarAlumno(Long id) {
        alumnoDAO.delete(id);

    }


    @Override
    public AlumnoDTO actualizarAlumno(Long id, AlumnoDTO alumnoDTO) {
        Alumno alumnoEncontrado = alumnoDAO.findById(id).orElseThrow();
        actualizarAtributos(id, alumnoDTO, alumnoEncontrado);
        Alumno alumnoGuardado = alumnoDAO.save(alumnoEncontrado);
        AlumnoDTO alumnoActualizado = modelMapper.map(alumnoGuardado, AlumnoDTO.class);
        return alumnoActualizado;
    }

    private static void actualizarAtributos(Long id, AlumnoDTO alumnoDTO, Alumno alumnoEncontrado) {
        alumnoEncontrado.setId(id);
        alumnoEncontrado.setNombre(alumnoDTO.getNombre());
        alumnoEncontrado.setEmail(alumnoDTO.getEmail());
        alumnoEncontrado.setLegajo(alumnoDTO.getLegajo());
    }
}
