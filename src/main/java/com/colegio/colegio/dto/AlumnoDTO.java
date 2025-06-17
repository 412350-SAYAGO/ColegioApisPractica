package com.colegio.colegio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data

public class AlumnoDTO {
    private Long id;
    @NotBlank(message = "El Nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El mail es obligatorio")
    @Email(message = "Debe ser un Email valido")
    private String email;

    private Integer legajo;

    List<Long> idMaterias;
}
