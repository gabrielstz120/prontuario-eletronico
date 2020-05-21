package io.github.gabrielstz120.repositories;

import io.github.gabrielstz120.models.Medico;
import io.github.gabrielstz120.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
