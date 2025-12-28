package org.example.treinoapp.repository;

import org.example.treinoapp.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExercicioRepository extends JpaRepository<Exercicio,Long> {
    Exercicio getExercicioById(Long l);
    List<Exercicio> getExercicioByNome(String nome);
    boolean existsExercicioById(Long l);
}
