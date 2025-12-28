package org.example.treinoapp.dto;

import org.example.treinoapp.model.GrupoMuscular;

public record ExercicioRequestDTO(
        String nome,
        String descricao,
        GrupoMuscular grupoMuscular
) {
}
