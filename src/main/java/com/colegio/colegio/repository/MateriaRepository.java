package com.colegio.colegio.repository;

import com.colegio.colegio.models.Materia;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
}
