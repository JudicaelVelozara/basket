package com.itu.basket.service;

import com.itu.basket.model.EquipeJoueur;
import com.itu.basket.repository.EquipeJoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeJoueurService {

    @Autowired
    private EquipeJoueurRepository EquipeJoueurRepository;

    public List<EquipeJoueur> getAllEquipeJoueurs() {
        return EquipeJoueurRepository.findAll();
    }

    public EquipeJoueur getEquipeJoueurById(Long id) {
        Optional<EquipeJoueur> EquipeJoueur = EquipeJoueurRepository.findById(id);
        return EquipeJoueur.orElse(null);
    }

    public EquipeJoueur createEquipeJoueur(EquipeJoueur EquipeJoueur) {
        return EquipeJoueurRepository.save(EquipeJoueur);
    }

    public EquipeJoueur updateEquipeJoueur(Long id, EquipeJoueur EquipeJoueur) {
        Optional<EquipeJoueur> EquipeJoueurData = EquipeJoueurRepository.findById(id);
        if (EquipeJoueurData.isPresent()) {
            EquipeJoueur updatedEquipeJoueur = EquipeJoueurData.get();
            updatedEquipeJoueur = EquipeJoueur;
            return EquipeJoueurRepository.save(updatedEquipeJoueur);
        } else {
            return null;
        }
    }

    public void deleteEquipeJoueur(Long id) {
        EquipeJoueurRepository.deleteById(id);
    }
}