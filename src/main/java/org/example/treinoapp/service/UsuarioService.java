package org.example.treinoapp.service;

import org.example.treinoapp.dto.UsuarioRequestDTO;
import org.example.treinoapp.dto.UsuarioResponseDTO;
import org.example.treinoapp.mapper.UsuarioMapper;
import org.example.treinoapp.model.Usuario;
import org.example.treinoapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.treinoapp.mapper.UsuarioMapper.toUsuario;
import static org.example.treinoapp.mapper.UsuarioMapper.toUsuarioResponseDTO;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = toUsuario(usuarioRequestDTO);
        return toUsuarioResponseDTO(usuarioRepository.save(usuario));
    }

    public UsuarioResponseDTO buscarUsuarioPorId(String id) {
        Usuario usuario = usuarioRepository.getUsuarioById(Long.parseLong(id));
        if (usuario == null) {
            throw new RuntimeException("Nenhum usuario encontrado");
        }
        return toUsuarioResponseDTO(usuario);
    }


    public List<UsuarioResponseDTO> buscarUsuarioPorNome(String nome) {
        List<Usuario> usuarios = usuarioRepository.getUsuarioByNome(nome);
        if (usuarios.isEmpty()) {
            throw new RuntimeException("Nenhum usuário encontrado com o nome: " + nome);
        }
        return usuarios.stream()
                .map(UsuarioMapper::toUsuarioResponseDTO)
                .toList();
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioMapper::toUsuarioResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO atualiazarUsuario(String id, UsuarioRequestDTO usuarioRequestDTO) {
        if (usuarioRepository.existsUsuarioById(Long.parseLong(id))) {
            Usuario usuarioExistente = usuarioRepository.getUsuarioById(Long.parseLong(id));
            Usuario usuarioAtualizado = toUsuario(usuarioRequestDTO);
            usuarioAtualizado.setId(usuarioExistente.getId());
            return toUsuarioResponseDTO(usuarioRepository.save(usuarioAtualizado));
        }
        throw new RuntimeException("Nenhum usuario encontrado");
    }

    public void removerUsuario(String id) {
        if (usuarioRepository.existsUsuarioById(Long.parseLong(id))) {
            usuarioRepository.deleteById(Long.parseLong(id));
        }
        throw new RuntimeException("Nenhum usuario encontrado");
    }
}