package com.itu.basket.service;

import com.itu.basket.model.Equipe;
import com.itu.basket.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    public Equipe getEquipeById(Long id) {
        Optional<Equipe> equipe = equipeRepository.findById(id);
        return equipe.orElse(null);
    }

    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Equipe updateEquipe(Long id, Equipe equipe) {
        Optional<Equipe> equipeData = equipeRepository.findById(id);
        if (equipeData.isPresent()) {
            Equipe updatedEquipe = equipeData.get();
            updatedEquipe.setNom(equipe.getNom());
            return equipeRepository.save(updatedEquipe);
        } else {
            return null;
        }
    }

    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }
}