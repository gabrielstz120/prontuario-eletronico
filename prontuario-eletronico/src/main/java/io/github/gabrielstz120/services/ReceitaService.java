package io.github.gabrielstz120.services;

import io.github.gabrielstz120.models.Paciente;
import io.github.gabrielstz120.models.Receita;
import io.github.gabrielstz120.repositories.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ReceitaService {

    private final ReceitaRepository receitaRepository;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;

    public Receita saveOrUpdate(Receita receita) {
        return receitaRepository.save(receita);
    }

    public Paciente findByCpf(Long cpf) {
        return pacienteService.findByCpf(cpf);
    }

    public List<String> getListaMedicos() {
        return medicoService.getMedicos();
    }

}
