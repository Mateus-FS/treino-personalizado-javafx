package org.example.treinoapp.dto;

import org.example.treinoapp.model.Genero;

import java.time.LocalDate;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        Integer idade,
        Genero genero,
        Double altura,
        Double peso
) {
}
