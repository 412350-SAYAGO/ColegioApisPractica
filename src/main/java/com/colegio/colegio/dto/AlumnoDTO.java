package com.colegio.colegio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class AlumnoDTO {
    private Long id;
    @NotBlank(message = "El Nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El mail es obligatorio")
    @Email(message = "Debe ser un Email valido")
    private String email;

    @NotBlank(message = "El legajo es obligatorio")
    private Integer legajo;
}
