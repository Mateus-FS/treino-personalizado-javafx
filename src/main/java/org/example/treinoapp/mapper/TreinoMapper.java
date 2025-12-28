package org.example.treinoapp.mapper;

import org.example.treinoapp.dto.TreinoRequestDTO;
import org.example.treinoapp.dto.TreinoResponseDTO;
import org.example.treinoapp.model.Objetivo;
import org.example.treinoapp.model.Treino;

import java.time.LocalDate;

public class TreinoMapper {

    public static TreinoResponseDTO toTreinoResponseDTO(Treino treino) {
        return  new TreinoResponseDTO(
                treino.getId(),
                treino.getNome(),
                treino.getObjetivo(),
                treino.getDataCriacao(),
                treino.isAtivo(),
                treino.getUsuario() != null ? treino.getUsuario().getId() : null,
                treino.getSessaoTreino() != null ? treino.getSessaoTreino().size() : 0
        );
    }

    public static Treino toTreino(TreinoRequestDTO treinoRequestDTO) {
        Treino treino = new Treino();
        treino.setNome(treinoRequestDTO.nome());
        treino.setObjetivo(treinoRequestDTO.objetivo());
        treino.setAtivo(treinoRequestDTO.ativo());
        return treino;
    }
}
