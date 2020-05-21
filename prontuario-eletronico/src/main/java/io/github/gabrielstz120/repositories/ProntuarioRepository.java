package io.github.gabrielstz120.repositories;

import io.github.gabrielstz120.models.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository  extends JpaRepository<Prontuario, Long> {

}
