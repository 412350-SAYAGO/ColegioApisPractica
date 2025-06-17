package com.colegio.colegio.dto;

import com.colegio.colegio.models.Alumno;
import com.colegio.colegio.models.Profesor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class MateriaDTO {

    private Long id;

    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;

    @NotNull(message = "Se debe agregar un profesor a la materia")
    private Long profesorId;

}
