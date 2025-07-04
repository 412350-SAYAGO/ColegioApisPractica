package com.colegio.colegio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private Integer legajo;

    @ManyToMany(mappedBy = "alumnos")
            @JsonIgnore
    List<Materia> marteriasCursadas;

}
