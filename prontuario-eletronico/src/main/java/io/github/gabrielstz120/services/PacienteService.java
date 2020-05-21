package io.github.gabrielstz120.services;

import io.github.gabrielstz120.models.Paciente;
import io.github.gabrielstz120.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente saveOrUpdate(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente findByCpf(Long cpf) {
        return pacienteRepository.findByCpf(cpf);
    }
}
