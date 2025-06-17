package com.colegio.colegio.service.impl;

import com.colegio.colegio.dao.AlumnoDAO;
import com.colegio.colegio.dao.MateriaDAO;
import com.colegio.colegio.dto.AlumnoDTO;
import com.colegio.colegio.models.Alumno;
import com.colegio.colegio.models.Materia;
import com.colegio.colegio.repository.AlumnoRepository;
import com.colegio.colegio.service.interf.AlumnoServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

@Service
public class AlumnoServiceImpl implements AlumnoServiceInterface {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AlumnoDAO alumnoDAO;

    @Autowired
    private MateriaDAO materiaDAO;


    @Override
    public List<AlumnoDTO> obtenerAlumnos() {
        List<Alumno> alumnosEncontrados = alumnoDAO.findAll();
        List<AlumnoDTO> alumnosMapeados = new ArrayList<>();
        for (Alumno alumno: alumnosEncontrados){
            AlumnoDTO alumnoDto = new AlumnoDTO();
            alumnoDto.setId(alumno.getId());
            alumnoDto.setEmail(alumno.getEmail());
            alumnoDto.setNombre(alumno.getNombre());
            alumnoDto.setLegajo(alumno.getLegajo());
            List<Long> idMaterias = new ArrayList<>();
            if(alumno.getMarteriasCursadas() != null){
                for(Materia materia : alumno.getMarteriasCursadas()){
                    idMaterias.add(materia.getId());
                }
            }
            alumnoDto.setIdMaterias(idMaterias);
            alumnosMapeados.add(alumnoDto);
        }
        return alumnosMapeados;
    }

    @Override
    public AlumnoDTO obtenerAlumnoPorId(Long id) {
        Alumno alumnoEncontrado = alumnoDAO.findById(id).orElseThrow();

        AlumnoDTO alumnoMapeado =  new AlumnoDTO();
        List<Long> idMaterias = new ArrayList<>();
            for(Materia materia : alumnoEncontrado.getMarteriasCursadas()){
                idMaterias.add(materia.getId());
            }


        alumnoMapeado.setId(id);
        alumnoMapeado.setIdMaterias(idMaterias);
        alumnoMapeado.setLegajo(alumnoEncontrado.getLegajo());
        alumnoMapeado.setNombre(alumnoEncontrado.getNombre());
        alumnoMapeado.setEmail(alumnoEncontrado.getEmail());

        return alumnoMapeado;
    }

    @Override
    public AlumnoDTO guardarAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumnoNuevo = new Alumno();

            List<Materia> materias = new ArrayList<>();
            for(Long idMateria : alumnoDTO.getIdMaterias()){
                Materia materia = materiaDAO.findById(idMateria).orElseThrow();
                materias.add(materia);
            }
            alumnoNuevo.setMarteriasCursadas(materias);

        alumnoNuevo.setLegajo(alumnoDTO.getLegajo());
        alumnoNuevo.setNombre(alumnoDTO.getNombre());
        alumnoNuevo.setEmail(alumnoDTO.getEmail());
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
