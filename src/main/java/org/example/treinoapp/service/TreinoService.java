package org.example.treinoapp.service;

import org.example.treinoapp.dto.TreinoRequestDTO;
import org.example.treinoapp.dto.TreinoResponseDTO;
import org.example.treinoapp.mapper.TreinoMapper;
import org.example.treinoapp.model.Treino;
import org.example.treinoapp.model.Usuario;
import org.example.treinoapp.repository.TreinoRepository;
import org.example.treinoapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.treinoapp.mapper.TreinoMapper.toTreino;
import static org.example.treinoapp.mapper.TreinoMapper.toTreinoResponseDTO;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public TreinoService(TreinoRepository treinoRepository, UsuarioRepository usuarioRepository) {
        this.treinoRepository = treinoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public TreinoResponseDTO salvarTreino(TreinoRequestDTO treinoRequestDTO) {
        Treino treino = toTreino(treinoRequestDTO);
        Usuario usuario = usuarioRepository.getUsuarioById(treinoRequestDTO.usuarioId());
        treino.setUsuario(usuario);
        return toTreinoResponseDTO(treinoRepository.save(treino));
    }

    public TreinoResponseDTO buscarTreinoPorId(String id) {
        Treino treino = treinoRepository.getTreinoById(Long.parseLong(id));
        if (treino == null) {
            throw new RuntimeException("Treino não encontrado.");
        }
        return toTreinoResponseDTO(treino);
    }

    public List<TreinoResponseDTO> buscarTreinoPorNome(String nome) {
        List<Treino> treinos = treinoRepository.getTreinoByNome(nome);
        if(treinos.isEmpty()) {
            throw new RuntimeException("Nenhum treino encontrado com o nome: " + nome);
        }
        return treinos.stream()
                .map(TreinoMapper::toTreinoResponseDTO)
                .toList();
    }

    public List<TreinoResponseDTO> listarTreinos() {
        List<Treino> treinos = treinoRepository.findAll();
        return treinos.stream()
                .map(TreinoMapper::toTreinoResponseDTO)
                .toList();
    }

    public TreinoResponseDTO atualiazarTreino(String id, TreinoRequestDTO treinoRequestDTO) {
        if (treinoRepository.existsTreinoById(Long.parseLong(id))) {
            Treino treinoExistente = treinoRepository.getTreinoById(Long.parseLong(id));
            Treino treinoAtualizado = toTreino(treinoRequestDTO);
            Usuario usuario = usuarioRepository.getUsuarioById(treinoRequestDTO.usuarioId());
            treinoAtualizado.setId(treinoExistente.getId());
            treinoAtualizado.setUsuario(usuario);
            return toTreinoResponseDTO(treinoRepository.save(treinoAtualizado));
        }
        throw new RuntimeException("Nenhum treino encontrado");
    }

    public void removerTreino(String id) {
        if (treinoRepository.existsTreinoById(Long.parseLong(id))) {
            treinoRepository.deleteById(Long.parseLong(id));
        }
        throw new RuntimeException("Nenhum treino encontrado");
    }

}

