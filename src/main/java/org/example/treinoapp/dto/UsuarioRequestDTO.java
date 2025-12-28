package org.example.treinoapp.dto;

import org.example.treinoapp.model.Genero;

import java.time.LocalDate;

public record UsuarioRequestDTO(
        String email,
        String senha,
        String nome,
        LocalDate dataNascimento,
        String telefone,
        Genero genero,
        Double altura,
        Double peso
) {
}
