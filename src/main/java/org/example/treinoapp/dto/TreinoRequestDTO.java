package org.example.treinoapp.dto;

import org.example.treinoapp.model.Objetivo;

public record TreinoRequestDTO(
        String nome,
        Objetivo objetivo,
        Long usuarioId,
        boolean ativo
) {
}
