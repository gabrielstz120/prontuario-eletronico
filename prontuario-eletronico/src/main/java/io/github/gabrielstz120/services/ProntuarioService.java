package io.github.gabrielstz120.services;

import io.github.gabrielstz120.models.Paciente;
import io.github.gabrielstz120.models.Prontuario;
import io.github.gabrielstz120.repositories.ProntuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProntuarioService {

    private final ProntuarioRepository prontuarioRepository;
    private final PacienteService pacienteService;

    public Prontuario saveOrUpdate(Prontuario prontuario) {
        return prontuarioRepository.save(prontuario);
    }

    public Paciente findByCpf(Long cpf) {
        return pacienteService.findByCpf(cpf);
    }

}
