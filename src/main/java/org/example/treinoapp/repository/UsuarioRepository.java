package org.example.treinoapp.repository;

import org.example.treinoapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario getUsuarioById(Long id);
    List<Usuario> getUsuarioByNome(String nome);
    boolean existsUsuarioById(Long l);
}
