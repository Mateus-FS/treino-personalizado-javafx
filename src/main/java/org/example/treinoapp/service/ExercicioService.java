package org.example.treinoapp.service;

import org.example.treinoapp.dto.ExercicioRequestDTO;
import org.example.treinoapp.dto.ExercicioResponseDTO;
import org.example.treinoapp.mapper.ExercicioMapper;
import org.example.treinoapp.model.Exercicio;
import org.example.treinoapp.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.treinoapp.mapper.ExercicioMapper.toExercicio;
import static org.example.treinoapp.mapper.ExercicioMapper.toExercicioResponseDTO;

@Service
public class ExercicioService {

    ExercicioRepository exercicioRepository;

    @Autowired
    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public ExercicioResponseDTO salvarExercicio(ExercicioRequestDTO exercicioRequestDTO) {
        Exercicio exercicio = toExercicio(exercicioRequestDTO);
        return toExercicioResponseDTO(exercicioRepository.save(exercicio));
    }

    public ExercicioResponseDTO buscarExercicioPorId(String id) {
        Exercicio exercicio = exercicioRepository.getExercicioById(Long.parseLong(id));
        if (exercicio == null) {
            throw new RuntimeException("Exercício não encontrado.");
        }
        return toExercicioResponseDTO(exercicio);
    }

    public List<ExercicioResponseDTO> buscarExercicioPorNome(String nome) {
        List<Exercicio> exercicios = exercicioRepository.getExercicioByNome(nome);
        if(exercicios.isEmpty()) {
            throw new RuntimeException("Nenhum exercício encontrado com o nome: " + nome);
        }
        return exercicios.stream()
                .map(ExercicioMapper::toExercicioResponseDTO)
                .toList();
    }

    public List<ExercicioResponseDTO> listarExercicios() {
        List<Exercicio> exercicios = exercicioRepository.findAll();
        return exercicios.stream()
                .map(ExercicioMapper::toExercicioResponseDTO)
                .toList();
    }

    public ExercicioResponseDTO atualiazarExercicio(String id, ExercicioRequestDTO exercicioRequestDTO) {
        if (exercicioRepository.existsExercicioById(Long.parseLong(id))) {
            Exercicio exercicioExistente = exercicioRepository.getExercicioById(Long.parseLong(id));
            Exercicio exercicioAtualizado = toExercicio(exercicioRequestDTO);
            exercicioAtualizado.setId(exercicioExistente.getId());
            return toExercicioResponseDTO(exercicioRepository.save(exercicioAtualizado));
        }
        throw new RuntimeException("Nenhum exercício encontrado");
    }

    public void removerExercicio(String id) {
        if (exercicioRepository.existsExercicioById(Long.parseLong(id))) {
            exercicioRepository.deleteById(Long.parseLong(id));
        }
        throw new RuntimeException("Nenhum exercício encontrado");
    }
}
