package com.colegio.colegio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;

    @ManyToOne
    @JoinColumn(name="profesor_id")
    Profesor profesor;

    @ManyToMany
    @JoinTable(name="materia_alumno", joinColumns = @JoinColumn(name = "materia_id"), inverseJoinColumns = @JoinColumn(name = "alumno_id"))
    List<Alumno> alumnos;

}
