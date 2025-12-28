package org.example.treinoapp.mapper;

import org.example.treinoapp.dto.ExercicioRequestDTO;
import org.example.treinoapp.dto.ExercicioResponseDTO;
import org.example.treinoapp.model.Exercicio;

public class ExercicioMapper {

    public static ExercicioResponseDTO toExercicioResponseDTO(Exercicio exercicio) {
        return new ExercicioResponseDTO(
                exercicio.getId(),
                exercicio.getNome(),
                exercicio.getDescricao(),
                exercicio.getGrupoMuscular()
        );
    }

    public static Exercicio toExercicio(ExercicioRequestDTO exercicioRequestDTO) {
        Exercicio exercicio = new Exercicio();
        exercicio.setNome(exercicioRequestDTO.nome());
        exercicio.setDescricao(exercicioRequestDTO.descricao());
        exercicio.setGrupoMuscular(exercicioRequestDTO.grupoMuscular());
        return exercicio;
    }
}
