package io.github.gabrielstz120.services;

import io.github.gabrielstz120.models.Medico;
import io.github.gabrielstz120.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public Medico saveOrUpdate(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<String> getMedicos() {
        return medicoRepository.findAll().stream()
                .map(Medico::getNome)
                .collect(Collectors.toList());
    }

}

