package org.example.treinoapp.mapper;

import org.example.treinoapp.dto.UsuarioRequestDTO;
import org.example.treinoapp.dto.UsuarioResponseDTO;
import org.example.treinoapp.model.Usuario;

import java.time.LocalDate;

public class UsuarioMapper {

    public static UsuarioResponseDTO toUsuarioResponseDTO(Usuario usuario) {
        Integer idadeCalculada = null;
        if (usuario.getDataNascimento() != null) {
            idadeCalculada = (int) java.time.temporal.ChronoUnit.YEARS.between(
                    usuario.getDataNascimento(),
                    LocalDate.now()
            );
        }
        return new UsuarioResponseDTO(
                usuario.getNome(),
                idadeCalculada,
                usuario.getGenero(),
                usuario.getAltura(),
                usuario.getPeso()
        );
    }

    public static Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioRequestDTO.email());
        usuario.setSenha(usuarioRequestDTO.senha());
        usuario.setNome(usuarioRequestDTO.nome());
        usuario.setDataNascimento(usuarioRequestDTO.dataNascimento());
        usuario.setTelefone(usuarioRequestDTO.telefone());
        usuario.setGenero(usuarioRequestDTO.genero());
        usuario.setAltura(usuarioRequestDTO.altura());
        usuario.setPeso(usuarioRequestDTO.peso());
        return usuario;
    }
}
