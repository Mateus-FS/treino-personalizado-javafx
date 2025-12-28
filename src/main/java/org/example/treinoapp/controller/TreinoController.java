package org.example.treinoapp.controller;

import org.example.treinoapp.dto.TreinoRequestDTO;
import org.example.treinoapp.dto.TreinoResponseDTO;
import org.example.treinoapp.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/treino-personalizado/treinos")
public class TreinoController {

    private final TreinoService treinoService;

    @Autowired
    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @PostMapping
    public ResponseEntity<TreinoResponseDTO> salvarTreino(@RequestBody TreinoRequestDTO treinoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(treinoService.salvarTreino(treinoRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoResponseDTO> buscarTreinoPorId(@PathVariable String id) {
        return ResponseEntity.ok(treinoService.buscarTreinoPorId(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<TreinoResponseDTO>> buscarTreinoPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(treinoService.buscarTreinoPorNome(nome));
    }

    @GetMapping
    public ResponseEntity<List<TreinoResponseDTO>> listarTreinos() {
        return ResponseEntity.ok(treinoService.listarTreinos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoResponseDTO> atualizarTreino(@PathVariable String id, @RequestBody TreinoRequestDTO treinoRequestDTO) {
        return ResponseEntity.ok(treinoService.atualiazarTreino(id, treinoRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTreino (@PathVariable String id) {
        treinoService.removerTreino(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
