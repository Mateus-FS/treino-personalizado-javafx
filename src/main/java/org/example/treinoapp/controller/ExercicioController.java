package org.example.treinoapp.controller;

import org.example.treinoapp.dto.ExercicioRequestDTO;
import org.example.treinoapp.dto.ExercicioResponseDTO;
import org.example.treinoapp.service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/treino-personalizado/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    @Autowired
    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @PostMapping
    public ResponseEntity<ExercicioResponseDTO> salvarExercicio(@RequestBody ExercicioRequestDTO exercicioRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exercicioService.salvarExercicio(exercicioRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioResponseDTO> buscarExercicioPorId(@PathVariable String id) {
        return ResponseEntity.ok(exercicioService.buscarExercicioPorId(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<ExercicioResponseDTO>> buscarExercicioPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(exercicioService.buscarExercicioPorNome(nome));
    }

    @GetMapping
    public ResponseEntity<List<ExercicioResponseDTO>> listarExercicios() {
        return ResponseEntity.ok(exercicioService.listarExercicios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExercicioResponseDTO> atualizarExercicio(@PathVariable String id, @RequestBody ExercicioRequestDTO exercicioRequestDTO) {
        return ResponseEntity.ok(exercicioService.atualiazarExercicio(id, exercicioRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerExercicio (@PathVariable String id) {
        exercicioService.removerExercicio(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
