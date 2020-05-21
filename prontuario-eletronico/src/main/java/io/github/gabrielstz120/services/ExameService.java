package io.github.gabrielstz120.services;

import io.github.gabrielstz120.models.Exame;
import io.github.gabrielstz120.repositories.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExameService {
    @Autowired
    private ExameRepository exameRepository;

    public Exame saveOrUpdate(Exame exame) {
        return exameRepository.save(exame);
    }
}
