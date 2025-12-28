package org.example.treinoapp.service;

import org.example.treinoapp.dto.UsuarioRequestDTO;
import org.example.treinoapp.dto.UsuarioResponseDTO;
import org.example.treinoapp.model.Usuario;
import org.example.treinoapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            throw new RuntimeException();
        }
        return toUsuarioResponseDTO(usuario);
    }




}
