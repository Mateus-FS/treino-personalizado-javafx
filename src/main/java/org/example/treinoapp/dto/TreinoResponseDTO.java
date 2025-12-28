package org.example.treinoapp.dto;

import org.example.treinoapp.model.Objetivo;

import java.time.LocalDate;

public record TreinoResponseDTO(
        Long id,
        String nome,
        Objetivo objetivo,
        LocalDate dataCriacao,
        boolean ativo,
        Long usuarioId,
        Integer totalSessoes
) {
}
