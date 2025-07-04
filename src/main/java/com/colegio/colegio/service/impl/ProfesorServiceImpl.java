package com.colegio.colegio.service.impl;

import com.colegio.colegio.config.ModelMapperConfig;
import com.colegio.colegio.dao.ProfesorDAO;
import com.colegio.colegio.dto.ProfesorDTO;
import com.colegio.colegio.models.Profesor;
import com.colegio.colegio.repository.ProfesorRepository;
import com.colegio.colegio.service.interf.ProfesorServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorServiceInterface {

    @Autowired
    private ProfesorDAO profesorDao;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<ProfesorDTO> obtenerProfesores() {
        List<Profesor> profesoresEncontrados = profesorDao.obtenerProfesores();
        List<ProfesorDTO> profesoresMapeados = new ArrayList<>();
        for (Profesor profesor: profesoresEncontrados){
            profesoresMapeados.add(modelMapper.map(profesor, ProfesorDTO.class));
        }
        return profesoresMapeados;
    }

    @Override
    public ProfesorDTO obtenerProfesorPorId(Long id) {
        Optional<Profesor> profesorEncontrado = profesorDao.obtenerProfesorPorId(id);
        return modelMapper.map(profesorEncontrado, ProfesorDTO.class);
    }

    @Override
    public ProfesorDTO guardarProfesor(ProfesorDTO profesorDTO) {
        Profesor profesor = modelMapper.map(profesorDTO, Profesor.class);
        Profesor profesorGuardado = profesorDao.guardarProfesor(profesor);
        return modelMapper.map(profesorGuardado, ProfesorDTO.class);
    }

    @Override
    public void eliminarProfesor(Long id) {
        profesorDao.eliminarProfesor(id);
    }

    @Override
    public ProfesorDTO actualizarProfesor(Long id, ProfesorDTO profesorDto) {
        Profesor profesor = profesorDao.obtenerProfesorPorId(id).orElseThrow();
        actualizarAtributosProfesor(id, profesorDto, profesor);
        Profesor profesorGuardado = profesorDao.guardarProfesor(profesor);
        ProfesorDTO profesorActualizado = modelMapper.map(profesorGuardado, ProfesorDTO.class);
        return profesorActualizado;
    }

    private static void actualizarAtributosProfesor(Long id, ProfesorDTO profesorDto, Profesor profesor) {
        profesor.setId(id);
        profesor.setNombre(profesorDto.getNombre());
        profesor.setEmail(profesorDto.getEmail());
        profesor.setTitulo(profesorDto.getTitulo());
    }
}
