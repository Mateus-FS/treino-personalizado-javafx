package org.example.treinoapp.repository;

import org.example.treinoapp.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreinoRepository  extends JpaRepository<Treino,Long> {
    Treino getTreinoById(long l);

    List<Treino> getTreinoByNome(String nome);

    boolean existsTreinoById(long l);
}
