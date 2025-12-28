package org.example.treinoapp.dto;

import org.example.treinoapp.model.GrupoMuscular;

public record ExercicioResponseDTO(
        Long id,
        String nome,
        String descricao,
        GrupoMuscular grupoMuscular
) {
}
