package com.itu.basket.service;

import com.itu.basket.model.Remplacement;
import com.itu.basket.repository.RemplacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemplacementService {

    @Autowired
    private RemplacementRepository RemplacementRepository;

    public List<Remplacement> getAllRemplacements() {
        return RemplacementRepository.findAll();
    }

    public Remplacement getRemplacementById(Long id) {
        Optional<Remplacement> Remplacement = RemplacementRepository.findById(id);
        return Remplacement.orElse(null);
    }

    public Remplacement createRemplacement(Remplacement Remplacement) {
        return RemplacementRepository.save(Remplacement);
    }

    public Remplacement updateRemplacement(Long id, Remplacement Remplacement) {
        Optional<Remplacement> RemplacementData = RemplacementRepository.findById(id);
        if (RemplacementData.isPresent()) {
            Remplacement updatedRemplacement = RemplacementData.get();
            updatedRemplacement = Remplacement;
            return RemplacementRepository.save(updatedRemplacement);
        } else {
            return null;
        }
    }

    public void deleteRemplacement(Long id) {
        RemplacementRepository.deleteById(id);
    }
}