package com.colegio.colegio.repository;


import com.colegio.colegio.models.Profesor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
